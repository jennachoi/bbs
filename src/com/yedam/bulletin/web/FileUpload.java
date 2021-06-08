package com.yedam.bulletin.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// 파일업로드를 하기 위한 서블릿
@WebServlet("/fileUpload")
public class FileUpload extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		String path = "D:/git/ore/bootstrap/img/product";
		ServletContext sc = this.getServletContext();
		path = sc.getRealPath("upload");

		MultipartRequest multi = new MultipartRequest(req, path, 8 * 1024 * 1024, "UTF-8",
				new DefaultFileRenamePolicy());

		Enumeration en = multi.getFileNames();
		String fileN = null;
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			String fileName = multi.getFilesystemName(name);
			fileN = fileName;
		}
		JsonObject json = new JsonObject();
		json.addProperty("uploaded", 1);
		json.addProperty("fileName", fileN);
		json.addProperty("url", req.getContextPath() + "/upload/" + fileN);

		resp.getWriter().print(json);
	}

}
