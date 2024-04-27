package io.ssafy.soupapi.domain.projectauth.api;

import io.ssafy.soupapi.domain.projectauth.application.ProjectAuthService;
import io.ssafy.soupapi.domain.projectauth.dto.response.GetProjectTeamMember;
import io.ssafy.soupapi.global.common.code.SuccessCode;
import io.ssafy.soupapi.global.common.response.BaseResponse;
import io.ssafy.soupapi.global.security.TemporalMember;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/projects/{projectId}/teams")
@RequiredArgsConstructor
@Tag(name = "프로젝트 팀", description = "ProjectAuth Domain Controller")
public class ProjectAuthController {
    private final ProjectAuthService projectAuthService;

    @Operation(summary = "프로젝트 팀원 정보 요청", description = "프로젝트 팀원들의 정보 및 권한 요청")
    @GetMapping
    @PreAuthorize("@authService.hasProjectRoleMember(#projectId, #member.getId())")
    public ResponseEntity<BaseResponse<List<GetProjectTeamMember>>> findProjectTeamMembers(
            @PathVariable(name = "projectId") String projectId,
            @AuthenticationPrincipal TemporalMember member
    ) {
        return BaseResponse.success(
                SuccessCode.SELECT_SUCCESS,
                projectAuthService.findProjectTeamMembers(projectId)
        );
    }
}
