package team.cupid.realworld.domain.comment.exception;

import team.cupid.realworld.global.error.exception.BusinessException;
import team.cupid.realworld.global.error.exception.ErrorCode;

public class CommentNotFoundException extends BusinessException {
    public CommentNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public CommentNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
