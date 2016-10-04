package com.github.natalialopessilva.cs20162.aula07;

/**
 * Implementação do Algoritmo Dia da Semana.
 *
 * <p>
 * Algoritmo correspondente obtido da Necessidade do cliente Método para
 * identificação do dia da semana de uma data observando várias restrições,
 * implementação da disciplina Construção de software do prof. Fábio Nogueira de
 * Lucena.
 *
 */
import java.time.LocalDate;

public class DiaDaSemana {

    /**
     * Verifica uma data fornecida pelo cliente e retorna o dia da Semana
     * correspondente a ela, a partir de uma data e dia da semana já conhecida.
     *
     * @param dataDesejada Uma data cujo dia da semana é desejado. A data é
     * fornecida por um inteiro no formato aaaammdd, onde o ano é fornecido por
     * meio dos quatro primeiros dígitos, o mês pelos dois dígitos seguintes e o
     * dia pelos últimos dois dígitos.
     * @param anoBissexto Um inteiro maior que zero correspondente a um ano
     * bissexto. Esse número será considerado um ano bissexto, independente de
     * ser ou não um ano bissexto.
     * @param dataConhecida Uma data conhecida. Ou seja, uma segunda data,
     * também fornecida no mesmo formato da primeira.
     * @param diaSemana Um dia da semana correspondente a data conhecida.O valor
     * deve estar entre 0 e 6, inclusive, para representar o dia da semana, onde
     * 0 é segunda-feira, 1 é terça-feira e assim sucessivamente.
     *
     * @return O dia da semana correspondente a data desejada, ou -1 caso um dos
     * valores de entrada não siga as seguintes restrições: A data cujo dia da
     * semana é desejado é inválida (nem todos os meses possuem 30 ou 31 dias,
     * por exemplo); A data cujo dia da semana é conhecido é inválida; O dia da
     * semana conhecido para uma dada data não seja um valor entre 0 e 6,
     * inclusive; O ano bissexto fornecido não seja um inteiro maior que zero.
     *
     */
    public static int diaSemana(int dataDesejada, int anoBissexto,
            int dataConhecida, int diaSemana) {

        if (!verificaData(dataDesejada) || !verificaData(dataConhecida)) {
            return -1;
        } else if (anoBissexto <= 0) {
            return -1;
        } else if (diaSemana < 0 || diaSemana > 6) {
            return -1;
        }

        //Separação do dia, ano e mes das respectivas datas
        String dataD = Integer.toString(dataDesejada);

        int diaDesejado = Integer.parseInt(dataD.substring(6));
        int mesDesejado = Integer.parseInt(dataD.substring(4, 6));
        int anoDesejado = Integer.parseInt(dataD.substring(0, 4));

        String dataC = Integer.toString(dataConhecida);

        int diaConhecido = Integer.parseInt(dataC.substring(6));
        int mesConhecido = Integer.parseInt(dataC.substring(4, 6));
        int anoConhecido = Integer.parseInt(dataC.substring(0, 4));

        //se a data desejada for maior que a data conhecida
        if ((anoConhecido < anoDesejado) || ((anoConhecido == anoDesejado)
                && (mesConhecido < mesDesejado)) || ((anoConhecido == anoDesejado)
                && (mesConhecido == mesDesejado) && (diaConhecido < diaDesejado))) {

            while (diaConhecido != diaDesejado || mesConhecido != mesDesejado
                    || anoConhecido != anoDesejado) {

                if ((mesConhecido == 1 || mesConhecido == 3 || mesConhecido == 5
                        || mesConhecido == 7 || mesConhecido == 8
                        || mesConhecido == 10) && (diaConhecido == 31)) {
                    diaConhecido = 0;
                    mesConhecido++;
                } else if ((mesConhecido == 4 || mesConhecido == 6
                        || mesConhecido == 9 || mesConhecido == 11)
                        && (diaConhecido == 30)) {
                    diaConhecido = 0;
                    mesConhecido++;
                } else if (mesConhecido == 2) {
                    if (verificaAnoBissexto(anoConhecido, anoBissexto)) {
                        if (diaConhecido == 29) {
                            diaConhecido = 0;
                            mesConhecido++;
                        }
                    } else if (diaConhecido == 28) {
                        diaConhecido = 0;
                        mesConhecido++;
                    }
                } else if (mesConhecido == 12 && diaConhecido == 31) {
                    diaConhecido = 0;
                    mesConhecido = 1;
                    anoConhecido++;
                }

                diaConhecido++;
                diaSemana++;
                if (diaSemana == 7) {
                    diaSemana = 0;
                }
            }
        } //se a data desejada for menor que a data conhecida
        else if ((anoConhecido > anoDesejado) || ((anoConhecido == anoDesejado)
                && (mesConhecido > mesDesejado)) || ((anoConhecido == anoDesejado)
                && (mesConhecido == mesDesejado) && (diaConhecido > diaDesejado))) {

            while (diaConhecido != diaDesejado || mesConhecido != mesDesejado
                    || anoConhecido != anoDesejado) {

                diaConhecido--;
                diaSemana--;
                if (diaSemana == -1) {
                    diaSemana = 6;
                }

                if ((mesConhecido == 5 || mesConhecido == 7 || mesConhecido == 10
                        || mesConhecido == 12) && (diaConhecido == 0)) {
                    diaConhecido = 30;
                    mesConhecido--;
                } else if ((mesConhecido == 2 || mesConhecido == 4
                        || mesConhecido == 6 || mesConhecido == 8
                        || mesConhecido == 9 || mesConhecido == 11)
                        && (diaConhecido == 0)) {
                    diaConhecido = 31;
                    mesConhecido--;
                } else if (mesConhecido == 3 && diaConhecido == 0) {
                    if (verificaAnoBissexto(anoConhecido, anoBissexto)) {
                        diaConhecido = 29;
                        mesConhecido--;

                    } else {
                        diaConhecido = 28;
                        mesConhecido--;
                    }
                } else if (mesConhecido == 1 && diaConhecido == 0) {
                    diaConhecido = 31;
                    mesConhecido = 12;
                    anoConhecido--;
                }
            }
        }

        return diaSemana;
    }

    /**Método que verifica a data recebida se está correta ou não, de acordo com
     * os padrões estabelecidos pelo cliente, e os padrões de uma data.
     * 
     * @param dataRecebida Uma data para verificação
     *
     * @return true se estiver está correta, e false se for inválida.
     */
    //
    public static boolean verificaData(int dataRecebida) {

        String data = Integer.toString(dataRecebida);

        if (data.length() == 8) {

            int dia = Integer.parseInt(data.substring(6));
            int mes = Integer.parseInt(data.substring(4, 6));
            int ano = Integer.parseInt(data.substring(0, 4));

            //Verificação de diase meses e cálculo de verificação do ano bissexto
            if (mes > 12 || mes < 1) {
                return false;
            } else if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8
                    || mes == 10 || mes == 12)
                    && (dia < 1 || dia > 31)) {
                return false;
            } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11)
                    && (dia < 1 || dia > 30)) {
                return false;
            } else if (mes == 2) {
                if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                    if (dia < 1 || dia > 29) {
                        return false;
                    }
                } else if (dia < 1 || dia > 28) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    /**Verifica se o ano verificada é um ano bissexto ou não pegando como 
     * referência o anoBissexto de referência
     * 
     * @param ano O ano da data desejada para verficação
     * @param anoBissextoReferencia Um numero inteiro maior que zero inserido 
     * anteriormente
     *
     * @return true para é um ano bissexto ou false para não é ano bissexto
     */
    public static boolean verificaAnoBissexto(int ano, int anoBissextoReferencia) {

        if (anoBissextoReferencia > ano) {
            while (ano < anoBissextoReferencia) {
                ano += 4;
            }
            return ano == anoBissextoReferencia;
        }
        if (anoBissextoReferencia < ano) {
            while (ano > anoBissextoReferencia) {
                ano -= 4;
            }
            return ano == anoBissextoReferencia;
        } else {
            return true;
        }
    }

    /**Verifica se o dia da Semana está realmente correto com uma verificação 
     * usando a classe LocalDate
     *
     * @param dataDesejada Uma data cujo dia da semana é desejado. A data é
     * fornecida por um inteiro no formato aaaammdd, onde o ano é fornecido por
     * meio dos quatro primeiros dígitos, o mês pelos dois dígitos seguintes e o
     * dia pelos últimos dois dígitos.
     * @param anoBissexto Um inteiro maior que zero correspondente a um ano
     * bissexto. Esse número será considerado um ano bissexto, independente de
     * ser ou não um ano bissexto.
     * @param dataConhecida Uma data conhecida. Ou seja, uma segunda data,
     * também fornecida no mesmo formato da primeira.
     * @param diaSemana Um dia da semana correspondente a data conhecida.O valor
     * deve estar entre 0 e 6, inclusive, para representar o dia da semana, onde
     * 0 é segunda-feira, 1 é terça-feira e assim sucessivamente.
     *
     * @return o dia da semana correspondente a data desejada.
     */
    public static int diaSemanaComLocalDate(int dataDesejada, int anoBissexto, 
            int dataConhecida,
            int diaSemana) {

        //Separação do dia, ano e mes das respectivas datas
        String data = Integer.toString(dataDesejada);

        int dia = Integer.parseInt(data.substring(6));
        int mes = Integer.parseInt(data.substring(4, 6));
        int ano = Integer.parseInt(data.substring(0, 4));

        LocalDate a = LocalDate.of(ano, mes, dia);
        return a.getDayOfWeek().ordinal();
    }
}
