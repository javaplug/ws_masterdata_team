package com.spark.masterdata.team.validator;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import com.spark.masterdata.team.dto.ResponseDTO;
import com.spark.masterdata.team.dto.TeamDTO;

@Component
public class TeamValidator {

    public ResponseDTO valid(TeamDTO teamDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (!NumberUtils.isCreatable(teamDTO.getLeadId())) {
            responseDTO.getErrors().put("leadId", "Please assign a valid Lead");
        }
        if (!NumberUtils.isCreatable(teamDTO.getDuration())) {
            responseDTO.getErrors().put("duration", "Please assign a valid Duration");
        }
        if (teamDTO.getStartDate() == null) {
            responseDTO.getErrors().put("startDate", "Please assign a valid Start Date");
        }
        if (!NumberUtils.isCreatable(teamDTO.getCreditPoints())) {
            responseDTO.getErrors().put("creditPoints", "Please assign a valid Credit Points");
        }
        return responseDTO;
    }
}
