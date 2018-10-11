package com.sinosoft.demo.web.printpdf;

import net.sf.jasperreports.j2ee.servlets.ImageServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="imageServlet",value="/servlets/image")
public class SinoSoftImageServlet extends ImageServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        super.service(request, response);
    }
}
