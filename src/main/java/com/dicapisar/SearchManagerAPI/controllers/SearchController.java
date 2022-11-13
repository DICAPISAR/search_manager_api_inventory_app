package com.dicapisar.SearchManagerAPI.controllers;

import com.dicapisar.SearchManagerAPI.dtos.response.ResultResponseDTO;
import com.dicapisar.SearchManagerAPI.exceptions.SessionErrorException;
import com.dicapisar.SearchManagerAPI.exceptions.SessionWithOutPermissionException;
import com.dicapisar.SearchManagerAPI.services.ISearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.dicapisar.SearchManagerAPI.commons.SearchManagerConstants.*;
import static com.dicapisar.SearchManagerAPI.utils.SessionUtils.validateSessionExist;
import static com.dicapisar.SearchManagerAPI.utils.SessionUtils.validateSessionHavePermissions;

@RestController
@AllArgsConstructor
public class SearchController {

    private ISearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<ResultResponseDTO> getResults(@RequestParam() String value, HttpSession session)
            throws SessionErrorException, SessionWithOutPermissionException {
        ArrayList<String> rolesPermissions = new ArrayList<>(List.of(ADMIN, MANAGER, EMPLOYED));
        validateSessionExist(session);
        validateSessionHavePermissions(session, rolesPermissions);
        return new ResponseEntity<>(searchService.getResult(value), HttpStatus.OK);
    }
}
