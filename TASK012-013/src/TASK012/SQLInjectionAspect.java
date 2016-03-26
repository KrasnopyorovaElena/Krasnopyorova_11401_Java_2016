package TASK012;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Elena.
 */
@Aspect
public class SQLInjectionAspect {
    //нахожу только лишь инъекции для select-ов
    //если не нашло инъекции на синтаксис SQL запрос не проверяю

    //проверка на инъекции после ввода числа
        private Pattern sqlInjectionForNumbers =
                Pattern.compile("(?i)(select)\\s+.+\\s+(from)\\s+.+\\s+(where)\\s+.+[=]\\d('|\\s+or\\s+.*|\\s+and\\s+.*)\\s*[;]");

    //проверка на инъекции после ввода строки
        private Pattern sqlInjectionForString =
            Pattern.compile("(?i)(select)\\s+.+\\s+(from)\\s+.+\\s+(where)\\s+.+[=\"].*[\"]\\s+(and|or)\\s+.*[\"].*[\"]\\s*[;]");

        private  Pattern sqlInjectionUnion=
                Pattern.compile("(?i)(select)\\s+.+\\s+(from)\\s+.+(where)\\s+.+(union)\\s*.*[;]");

        private  Pattern stackedQueriesSqlInjection=
            Pattern.compile("((?i)(select)\\s+.+\\s+(from)\\s+.+(where)\\s+.+[;])+");

        @Around("execution(* *..*.executeStatement(String))")
        public Object checkingSQLInjection(ProceedingJoinPoint jp) throws Throwable {
            System.out.println("Checking sql injection");
            String statement = (String) jp.getArgs()[0];
            Matcher matcherInjectionNumber = sqlInjectionForNumbers.matcher(statement);
            Matcher matcherInjectionString = sqlInjectionForString.matcher(statement);
            Matcher matcherInjectionUnion = sqlInjectionUnion.matcher(statement);
            Matcher matcherStackedInjection = stackedQueriesSqlInjection.matcher(statement);

            if (matcherInjectionNumber.matches()) {
                System.out.println("SQL injection for numbers");
                return false;
            }
            if (matcherInjectionString.matches()) {
                System.out.println("SQL injection for string");
                return false;
            }

            if (matcherInjectionUnion.matches()) {
                System.out.println("SQL injection with Union");
                return false;
            }

            if (matcherStackedInjection.matches()) {
                System.out.println("Stacked Queries SQL injection ");
                return false;
            }
            return jp.proceed();
        }

    }

