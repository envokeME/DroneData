package com.dronerecon.ws;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class PortalDBService extends HttpServlet{

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");

        PrintWriter out = response.getWriter();

		// ############
		// Get 5 parameter values from the request object (these are passed in from part 1 code).
		// "area_id" : String type
		// "tilex" : int type (Reference part 1 of Project 2 for converting string to int).
		// "tiley"
		// "r"
		// "g"
       String sArea_ID = request.getParameter("area_id");
       int sTilex = Integer.parseInt(request.getParameter("tilex"));
       int sTiley = Integer.parseInt(request.getParameter("tiley"));
        int iR = Integer.parseInt(request.getParameter("r"));
       int iG = Integer.parseInt(request.getParameter("g"));
        // ############
        


		// ############
		// Instantiate a DBManager instance.
		// ############
        DBManager oDBManager = new DBManager();
        // Set DB location (Currently uses current DB file name and adds direct path from C drive before it).
        oDBManager.DBLocation = System.getProperty("catalina.base") + "\\webapps\\dronereconportal\\db\\" +
            oDBManager.DBLocation;

		// ############
		// Call insertAreaGridTile on db manager object and pass the 5 values from above.
        // ############
        oDBManager.insertAreaGridTile(sArea_ID,sTilex,sTiley,iR,iG);

        // Response with confirmation of DB record written.
        out.println("{\"success\":true}");
    }
}

