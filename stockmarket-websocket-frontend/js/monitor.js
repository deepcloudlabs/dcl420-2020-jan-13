class DashboardViewModel {
    constructor() {
        // domain related observables
        this.symbol = ko.observable();
        this.windowSize = ko.observable();
        this.monitoring = ko.observable(false);

        this.data = {
            labels: ko.observableArray([]),
            datasets: [
                {
                    label: ['BTCUSDT'],
                    backgroundColor: "rgba(120,120,120,0.2)",
                    borderColor: "rgba(120,120,120,1)",
                    pointColor: "rgba(120,120,120,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(120,120,120,1)",
                    data: ko.observableArray([])
                }
            ]
        };

        this.changeLng = this.changeLng.bind(this);
        this.i18n = this.i18n.bind(this);
        this.translate = this.translate.bind(this);
        this.start = this.start.bind(this);
        this.stop = this.stop.bind(this);
        this.enableTradingView = this.enableTradingView.bind(this);

        this.connect();
    }

    connect() {
        this.websocket = new WebSocket(AppConfig.WS_URL);
        this.websocket.onopen = () => {
            toastr.success("Connected to the server!");
        }
        this.websocket.onclose = () => {
            toastr.error("Disconnected from the server!");
        }
        this.websocket.onmessage = (payload) => {
            if (!this.monitoring()) return;
            let trade = JSON.parse(payload.data);
            this.data.datasets[0].data.push(trade.price);
            let now = new Date().toTimeString()
                .replace(/.*(\d{2}:\d{2}:\d{2}).*/,
                    '$1');
            this.data.labels.push(now);
            let length =
                this.data.datasets[0].data().length;
            let size = length - this.windowSize();
            if (size > 0) {
                let slicedData =
                    this.data.datasets[0].data.slice(size);
                this.data.datasets[0].data(slicedData);
                let slicedLabel =
                    this.data.labels.slice(size);
                this.data.labels(slicedLabel);
            }
        };
    }

    enableTradingView() {
        new TradingView.widget({
            'container_id': 'dcl',
            'width': 800,
            'height': 600,
            'symbol': 'BINANCE:BTCUSDT',
            'interval': 'D',
            'timezone': 'Etc/UTC',
            'theme': 'Light',
            'style': '1',
            'locale': 'tr',
            'toolbar_bg': '#f1f3f6',
            'enable_publishing': false,
            'withdateranges': true,
            'hide_side_toolbar': false,
            'allow_symbol_change': true,
            'watchlist': [
                'BINANCE:BTCUSDT',
                'BINANCE:ETHBTC',
                'BINANCE:LTCBTC',
                'BINANCE:XRPBTC',
                'BINANCE:BCCBTC',
                'BINANCE:DASHBTC',
                'BINANCE:ADABTC',
                'BINANCE:NEOBTC',
                'BINANCE:EOSBTC',
                'BINANCE:LTCUSDT',
                'BINANCE:XRPUSDT',
                'BINANCE:EOSUSD',
                'BINANCE:NEOUSDT',
                'BINANCE:ADAUSDT',
                'BINANCE:XLMUSD',
                'BINANCE:XLMBTC'
            ],
            'details': true,
            'hideideas': false,
            'studies': [
                'MACD@tv-basicstudies'
            ],
            'show_popup_button': false
        });
    };

    // i18n
    changeLng(lng) {
        i18n.setLng(lng, () => {
            this.i18n();
        });
    };

    i18n() {
        $(document).i18n();
    };

    translate(word) {
        return i18n.t(word);
    };

    // starts monitoring
    start() {
        this.monitoring(true);
        toastr.success(i18n.t("messageMonitoringStarted"), "", AppConfig.TOASTR_CONFIG);
        this.enableTradingView();

    };

    // stops monitoring
    stop() {
        this.monitoring(false);
        toastr.warning(i18n.t("messageMonitoringStoped"), "", AppConfig.TOASTR_CONFIG);
    };

};

var dashBoardViewModel = new DashboardViewModel();

$(() => {
    i18n.init(AppConfig.I18N_CONFIG, (t) => {
        $(document).i18n();
        ko.applyBindings(dashBoardViewModel);
    });
});