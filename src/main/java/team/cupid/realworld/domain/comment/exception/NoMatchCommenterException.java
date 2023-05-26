package team.cupid.realworld.domain.comment.exception;

import team.cupid.realworld.global.error.exception.BusinessException;
import team.cupid.realworld.global.error.exception.ErrorCode;

public class NoMatchCommenterException extends BusinessException {
    public NoMatchCommenterException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public NoMatchCommenterException(ErrorCode errorCode) {
        super(errorCode);
    }
}
