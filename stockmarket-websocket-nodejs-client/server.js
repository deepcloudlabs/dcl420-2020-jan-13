const WebSocket = require('ws');

const url = 'ws://localhost:8080/stockmarket-backend/stream';

const connection = new WebSocket(url);

connection.onopen = () => {
    console.log('Connected to the server');
}

connection.onclose = () => {
    console.log('Disconnected from the server');
}

connection.onmessage = (frame) => {
    console.log(frame.data);
}