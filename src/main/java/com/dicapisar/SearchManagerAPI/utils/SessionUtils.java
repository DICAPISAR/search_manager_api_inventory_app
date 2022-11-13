package com.dicapisar.SearchManagerAPI.utils;

import com.dicapisar.SearchManagerAPI.exceptions.SessionErrorException;
import com.dicapisar.SearchManagerAPI.exceptions.SessionWithOutPermissionException;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static com.dicapisar.SearchManagerAPI.commons.SearchManagerConstants.ROL_NAME;


public class SessionUtils {
    public static void validateSessionExist(HttpSession session) throws SessionErrorException {
        if (session.getAttribute(ROL_NAME) == null) {
            throw new SessionErrorException();
        }
    }

    public static void validateSessionHavePermissions(HttpSession session, ArrayList<String> permissionList)
            throws SessionWithOutPermissionException {
      if (!permissionList.contains(session.getAttribute(ROL_NAME))){
          throw new SessionWithOutPermissionException();
      }
    }

}
