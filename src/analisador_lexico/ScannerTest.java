package analisador_lexico;

public class ScannerTest {

    private static void testar(
            String nome,
            String codigo,
            TokenType tipoEsperado,
            String lexemaEsperado) {

        Scanner scanner = new Scanner(codigo);
        Token token = scanner.nextToken();

        assert token.tipo == tipoEsperado :
                nome + " - esperado " + tipoEsperado +
                ", mas recebeu " + token.tipo;

        assert token.lexema.equals(lexemaEsperado) :
                nome + " - esperado '" + lexemaEsperado +
                "', mas recebeu '" + token.lexema + "'";

        System.out.println(nome + " passou -> " + token);
    }

    public static void main(String[] args) {

        testar(
            "Teste 1 - Identificador",
            "idade",
            TokenType.IDENTIFICADOR,
            "idade"
        );

        testar(
            "Teste 2 - Palavra reservada",
            "int",
            TokenType.PALAVRA_RESERVADA,
            "int"
        );

        testar(
            "Teste 3 - Literal numérico",
            "3.14",
            TokenType.LITERAL_NUMERICO,
            "3.14"
        );

        testar(
            "Teste 4 - String",
            "\"Olá\"",
            TokenType.STRING,
            "\"Olá\""
        );

        testar(
            "Teste 5 - Operador simples",
            "+",
            TokenType.OPERADOR,
            "+"
        );

        testar(
            "Teste 6 - Operador composto",
            "==",
            TokenType.OPERADOR,
            "=="
        );

        testar(
            "Teste 7 - Operador lógico",
            "&&",
            TokenType.OPERADOR,
            "&&"
        );

        testar(
            "Teste 8 - Delimitador",
            ";",
            TokenType.DELIMITADOR,
            ";"
        );

        testar(
            "Teste 9 - Char",
            "'a'",
            TokenType.CHAR_LITERAL,
            "'a'"
        );

        testar(
            "Teste 10 - Caractere inválido",
            "@",
            TokenType.ERRO,
            "Caractere inválido: @"
        );

        System.out.println("\nTodos os testes básicos passaram!");
    }
}