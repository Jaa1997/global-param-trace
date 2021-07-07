package com.adu21.spring.boot.global.param.trace.serivce.permission;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Service("SaveUserAuthorizationService")
public class SaveUserAuthorizationService extends AuthorizationService {
    private List<Long> authorizedUserIds = Arrays.asList(1L, 2L, 3L, 4L, 5L);

    @Override
    public boolean isGranted(Long userId) {
        return authorizedUserIds.contains(userId);
    }
}
