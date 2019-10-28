package com.dronerecon.ws;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.security.SecureRandom;

/**
 *Author: Ahmed Mohamed
 * Project: 2
 * Date: 05/01/2018
 */
public class DroneDataService extends HttpServlet
{


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");

        PrintWriter out = response.getWriter();

        // ##############################
        // 1. Get params passed in.

        // Get the following parameters from the request object and put them into strings:
        // area_id
        String sArea_id = request.getParameter("area_id");
        // tilex
        String sTilex = request.getParameter("tilex");
        // tiley
        String sTiley = request.getParameter("tiley");
        // totalcols
        String sTotalcols = request.getParameter("totalcols");
        // totalrows
        String sTotalrows = request.getParameter("totalrows");
        // ##############################


        //for part 2 get :
        //r
        //g
       // DBManager getRG = new DBManager();
        String sG = request.getParameter("g");
        String sR = request.getParameter("r");


        //call web service in part 2(PortalDBService)
        //URL format
        //http://127.0.0.1:8080/dronereconportal/PortalDBService?area_id=

        //call API
        try
        {
            URL url = new URL("http://127.0.0.1:8080/dronereconportal/PortalDBService?area_id=" + sArea_id + "&tilex=" + sTilex +"&tiley=" + sTiley + "&r= " + sR  +"&g=" + sG);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine()))
            {

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            // ##############################
            // 2. Default value of beginning direction.

            // Set a string called sDirection to "right".
            // ##############################
            String sDirection = "right";


            // ##############################
            // 3. Calculate next drone move.

            // Determine next tile to move to.
            // Base this on current x and y.
            // Change sDirection if necessary.
            // Drone must serpentine from top left of grid back and forth down.
            // If rows are done, change sDirection to "stop".

            //Check if on even row.
            //Currently going right.
            //check if at end of row by comparing current x to total cols.
            //increase row (next y) by 1 and change sDirection to "left".
            //else increase col (next x) by 1.

            //Else it's on an odd row.
            //currently going left.
            //check if at far left end of row by checking current x is 0.
            //increase row (next y) by 1 amd change sDirection to "right".
            //else decrease col (next x) by 1.

            //if next y is equal to total rows
            //set sDirection to "stop"

        int iTiley = Integer.parseInt(sTiley);
        int iTilex = Integer.parseInt(sTilex);
        int icols = Integer.parseInt(sTotalcols);
        int irows = Integer.parseInt(sTotalrows);

            if(iTiley%2==0)
            {
                if(iTilex==icols-1)
                {
                    iTiley++;
                    sDirection = "left";
                }
                else
                    {
                        iTilex++;
                    }
            }
            else
                {
                    if(iTilex==0)
                    {
                        iTiley++;
                    }
                    else
                        {
                            iTilex++;
                        }
                        if(iTiley==irows)
                        {
                            sDirection = "stop";
                        }
                }







        // ##############################



        // ##############################
        // 4. Format & Return JSON string to caller.

        /* Return via out.println() a JSON string like this:
        {"area_id":"[area id from above]", "nextTileX":"[next tile x]", "nextTileY":"[next tile y]", "direction":"[direction string from above]"}
        */
        String sReturnJson = "{\"area_id\":\"" + sArea_id + "\", \"nextTileX\":\"" + sTilex + "\", \"nextTileY\":\"" + sTiley + "\", \"direction\":\"" + sDirection + "\"}";
        out.println(sReturnJson);
        // ##############################

    }
}

