package mars.util;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
public abstract class Asserts {

    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    public static void isTrue(boolean expression, Object message) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(message));
        }
    }

    public static void isTrue(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
        if(!expression) {
            throw new IllegalArgumentException(String.format(errorMessageTemplate, errorMessageArgs));
        }
    }

    public static void isNull(Object object) {
        isNull(object, "[Assertion failed] - the object argument must be null");
    }

    public static void isNull(Object object, Object message) {
        if (object != null) {
            throw new IllegalArgumentException(String.valueOf(message));
        }
    }

    public static void isNull(Object object, String errorMessageTemplate, Object... errorMessageArgs) {
        if (object != null) {
            throw new IllegalArgumentException(String.format(errorMessageTemplate, errorMessageArgs));
        }
    }

    public static void notNull(Object object) {
        notNull(object, "[Assertion failed] - this argument is required; it must not be null");
    }

    public static void notNull(Object object, Object message) {
        if (object == null) {
            throw new IllegalArgumentException(String.valueOf(message));
        }
    }

    public static void notNull(Object object, String errorMessageTemplate, Object... errorMessageArgs) {
        if (object == null) {
            throw new NullPointerException(String.format(errorMessageTemplate, errorMessageArgs));
        }
    }

    public static void notEmpty(String text) {
        notEmpty(text,
                "[Assertion failed] - this String argument must have length; it must not be null or empty");
    }

    public static void notEmpty(String text, Object message) {
        if (StringUtils.isEmpty(text)) {
            throw new IllegalArgumentException(String.valueOf(message));
        }
    }

    public static void notEmpty(String text, String errorMessageTemplate, Object... errorMessageArgs) {
        if (StringUtils.isEmpty(text)) {
            throw new IllegalArgumentException(String.format(errorMessageTemplate, errorMessageArgs));
        }
    }

    public static void notBlank(String text) {
        notBlank(text,
                "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
    }

    public static void notBlank(String text, Object message) {
        if (!StringUtils.isNotBlank(text)) {
            throw new IllegalArgumentException(String.valueOf(message));
        }
    }

    public static void notBlank(String text, String errorMessageTemplate, Object... errorMessageArgs) {
        if (!StringUtils.isNotBlank(text)) {
            throw new IllegalArgumentException(String.format(errorMessageTemplate, errorMessageArgs));
        }
    }
}
