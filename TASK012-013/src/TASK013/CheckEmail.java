package TASK013;

/**
 * Created by Elena.
 */

    import org.aspectj.lang.ProceedingJoinPoint;
    import org.aspectj.lang.annotation.Around;
    import org.aspectj.lang.annotation.Aspect;

    import java.util.regex.Matcher;
    import java.util.regex.Pattern;


    @Aspect
    public class CheckEmail {
        //\u002E- точка
        //\u002F- нижнее подчеркивание
        private Pattern email = Pattern.compile("[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))", Pattern.CASE_INSENSITIVE);

        @Around("execution(* *..*.setEmail(String))")
        public Object checkForSQLInjection(ProceedingJoinPoint jp) throws Throwable {
            System.out.println("Checking email");
            String statement = (String) jp.getArgs()[0];
            Matcher matcher = email.matcher(statement);
            if (matcher.matches()) {
                System.out.println("email was correct");
                return jp.proceed();
            }
            System.out.println("email was incorrect");
            return null;
        }

    }

