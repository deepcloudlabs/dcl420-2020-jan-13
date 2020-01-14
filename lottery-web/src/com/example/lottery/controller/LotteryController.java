package com.example.lottery.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.lottery.model.LotteryModel;
import com.example.lottery.service.LotteryService;

@WebServlet(urlPatterns = "/draw")
public class LotteryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private LotteryService lotterySrv;
	@Inject
	private LotteryModel lotteryModel;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int n = 1;
		try {
			n = Integer.parseInt(request.getParameter("n"));
		} catch (NumberFormatException e) {
		}
		lotteryModel.getNumbers().addAll(lotterySrv.draw(n));
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
