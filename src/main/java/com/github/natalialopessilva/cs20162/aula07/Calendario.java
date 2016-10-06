/*
 * 2016 - Instituto de Informática (UFG)
 */
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

/**
 * Implementação da Classe Calendario.
 *
 * <p>
 * Implementa um algoritmo para determinar o dia da semana de uma certa data,
 * disponibilizada pelo usuário, através de várias restrições e segmentos,
 * impostas pelo exercício.
 *
 */
public final class Calendario {

    /**
     * Construtor da Classe Calendário.
     */
    private Calendario() {
    }

    /**
     * Número que indica quando algo na entrada não deu certo.
     */
    public static final int SAIDA_INVALIDA = -1;

    /**
     * Número que indica o número de dias para os meses que possuem 31 dias.
     */
    public static final int NUM_DIAS_MES_31 = 31;

    /**
     * Número que indica o número de dias para os meses que possuem 30 dias.
     */
    public static final int NUM_DIAS_MES_30 = 30;

    /**
     * Número que indica o número de dias para os meses que possuem 29 dias.
     */
    public static final int NUM_DIAS_MES_29 = 29;

    /**
     * Número que indica o número de dias para os meses que possuem 28 dias.
     */
    public static final int NUM_DIAS_MES_28 = 28;

    /**
     * Número que indica o mês de Janeiro.
     */
    public static final int MES_JANEIRO = 1;

    /**
     * Número que indica o mês de Fevereiro.
     */
    public static final int MES_FEVEREIRO = 2;

    /**
     * Número que indica o mês de Fevereiro.
     */
    public static final int MES_MARCO = 3;

    /**
     * Número que indica o mês de Fevereiro.
     */
    public static final int MES_ABRIL = 4;

    /**
     * Número que indica o mês de Fevereiro.
     */
    public static final int MES_MAIO = 5;

    /**
     * Número que indica o mês de Fevereiro.
     */
    public static final int MES_JUNHO = 6;

    /**
     * Número que indica o mês de Fevereiro.
     */
    public static final int MES_JULHO = 7;

    /**
     * Número que indica o mês de Fevereiro.
     */
    public static final int MES_AGOSTO = 8;

    /**
     * Número que indica o mês de Fevereiro.
     */
    public static final int MES_SETEMBRO = 9;

    /**
     * Número que indica o mês de Fevereiro.
     */
    public static final int MES_OUTUBRO = 10;

    /**
     * Número que indica o mês de Fevereiro.
     */
    public static final int MES_NOVEMBRO = 11;

    /**
     * Número que indica o mês de Fevereiro.
     */
    public static final int MES_DEZEMBRO = 12;

    /**
     * Número que indica o dia da semana: Domingo.
     */
    public static final int DOMINGO = 0;

    /**
     * Número que indica o dia da semana: Segunda.
     */
    public static final int SEGUNDA = 1;

    /**
     * Número que indica o dia da semana: Terca.
     */
    public static final int TERCA = 2;

    /**
     * Número que indica o dia da semana: Quarta.
     */
    public static final int QUARTA = 3;

    /**
     * Número que indica o dia da semana: Quinta.
     */
    public static final int QUINTA = 4;

    /**
     * Número que indica o dia da semana: Sexta.
     */
    public static final int SEXTA = 5;

    /**
     * Número que indica o dia da semana: Sábado.
     */
    public static final int SABADO = 6;

    /**
     * Número que faz parte da verificação do ano bissexto.
     */
    public static final int VERIFICA_ANO_BISSEXTO_4 = 4;

    /**
     * Número que indica o limite do dia na string, no momento da separação de
     * dia, mês e ano.
     */
    public static final int LIMITE_DIA = 6;

    /**
     * Número que indica o limite do mês na string, no momento da separação de
     * dia, mês e ano.
     */
    public static final int LIMITE_MES = 4;

    /**
     * Número que indica o limite do ano na string, no momento da separação de
     * dia, mês e ano.
     */
    public static final int LIMITE_ANO = 0;

    /**
     * Número que indica o limite de caractéres que as datas inseridas pelo
     * usuário devem assumir.
     */
    public static final int LIMITE_CARACTERES_DATA = 8;

    /**
     * Verifica uma data fornecida pelo cliente e retorna o dia da Semana
     * correspondente a ela, a partir de uma data e dia da semana já conhecida.
     *
     * @param data1 Uma data cujo dia da semana é desejado. A data é fornecida
     * por um inteiro no formato aaaammdd, onde o ano é fornecido por meio dos
     * quatro primeiros dígitos, o mês pelos dois dígitos seguintes e o dia
     * pelos últimos dois dígitos.
     * @param anoBissextoReferencia Um inteiro maior que zero correspondente a
     * um anobissexto. Esse número será considerado um ano bissexto,
     * independente de ser ou não um ano bissexto.
     * @param data2 Uma data conhecida. Ou seja, uma segunda data, também
     * fornecida no mesmo formato da primeira.
     * @param diaSemanaReferencia Um dia da semana correspondente a data
     * conhecida.O valor deve estar entre 0 e 6, inclusive, para representar o
     * dia da semana, onde 0 é segunda-feira, 1 é terça-feira e assim
     * sucessivamente.
     *
     * @return O dia da semana correspondente a data desejada, ou -1 caso um dos
     * valores de entrada não siga as seguintes restrições: A data cujo dia da
     * semana é desejado é inválida (nem todos os meses possuem 30 ou 31 dias,
     * por exemplo); A data cujo dia da semana é conhecido é inválida; O dia da
     * semana conhecido para uma dada data não seja um valor entre 0 e 6,
     * inclusive; O ano bissexto fornecido não seja um inteiro maior que zero.
     *
     */
    public static int diaSemana(final int data1,
            final int anoBissextoReferencia, final int data2,
            final int diaSemanaReferencia) {

        int dataDesejada = data1;
        int anoBissexto = anoBissextoReferencia;
        int dataConhecida = data2;
        int diaSemana = diaSemanaReferencia;

        if (!verificaData(dataDesejada, anoBissextoReferencia)
                || !verificaData(dataConhecida, anoBissextoReferencia)) {
            return SAIDA_INVALIDA;
        } else if (anoBissexto <= 0) {
            return SAIDA_INVALIDA;
        } else if (diaSemana < 0 || diaSemana > SABADO) {
            return SAIDA_INVALIDA;
        }

        //Separação do dia, ano e mês das respectivas datas
        String dataD = Integer.toString(dataDesejada);

        int diaDesejado = Integer.parseInt(dataD.substring(LIMITE_DIA));
        int mesDesejado = Integer.parseInt(dataD.substring(LIMITE_MES,
                LIMITE_DIA));
        int anoDesejado = Integer.parseInt(dataD.substring(LIMITE_ANO,
                LIMITE_MES));

        String dataC = Integer.toString(dataConhecida);

        int diaConhecido = Integer.parseInt(dataC.substring(LIMITE_DIA));
        int mesConhecido = Integer.parseInt(dataC.substring(LIMITE_MES,
                LIMITE_DIA));
        int anoConhecido = Integer.parseInt(dataC.substring(LIMITE_ANO,
                LIMITE_MES));

        //se a data desejada for maior que a data conhecida
        if ((anoConhecido < anoDesejado) || ((anoConhecido == anoDesejado)
                && (mesConhecido < mesDesejado))
                || ((anoConhecido == anoDesejado)
                && (mesConhecido == mesDesejado)
                && (diaConhecido < diaDesejado))) {

            while (diaConhecido != diaDesejado || mesConhecido != mesDesejado
                    || anoConhecido != anoDesejado) {

                if ((mesConhecido == MES_JANEIRO || mesConhecido == MES_MARCO
                        || mesConhecido == MES_MAIO || mesConhecido == MES_JULHO
                        || mesConhecido == MES_AGOSTO
                        || mesConhecido == MES_OUTUBRO)
                        && (diaConhecido == NUM_DIAS_MES_31)) {
                    diaConhecido = 0;
                    mesConhecido++;
                } else if ((mesConhecido == MES_ABRIL
                        || mesConhecido == MES_JUNHO
                        || mesConhecido == MES_SETEMBRO
                        || mesConhecido == MES_NOVEMBRO)
                        && (diaConhecido == NUM_DIAS_MES_30)) {
                    diaConhecido = 0;
                    mesConhecido++;
                } else if (mesConhecido == MES_FEVEREIRO) {
                    if (verificaAnoBissexto(anoConhecido, anoBissexto)) {
                        if (diaConhecido == NUM_DIAS_MES_29) {
                            diaConhecido = 0;
                            mesConhecido++;
                        }
                    } else if (diaConhecido == NUM_DIAS_MES_28) {
                        diaConhecido = 0;
                        mesConhecido++;
                    }
                } else if (mesConhecido == MES_DEZEMBRO
                        && diaConhecido == NUM_DIAS_MES_31) {
                    diaConhecido = 0;
                    mesConhecido = MES_JANEIRO;
                    anoConhecido++;
                }

                diaConhecido++;
                diaSemana++;
                if (diaSemana == SABADO + 1) {
                    diaSemana = DOMINGO;
                }
            }
        } else if ((anoConhecido > anoDesejado)
                || ((anoConhecido == anoDesejado)
                && (mesConhecido > mesDesejado))
                || ((anoConhecido == anoDesejado)
                && (mesConhecido == mesDesejado)
                && (diaConhecido > diaDesejado))) {

            while (diaConhecido != diaDesejado || mesConhecido != mesDesejado
                    || anoConhecido != anoDesejado) {

                diaConhecido--;
                diaSemana--;
                if (diaSemana == -1) {
                    diaSemana = SABADO;
                }

                if ((mesConhecido == MES_MAIO || mesConhecido == MES_JULHO
                        || mesConhecido == MES_OUTUBRO
                        || mesConhecido == MES_DEZEMBRO)
                        && (diaConhecido == 0)) {
                    diaConhecido = NUM_DIAS_MES_30;
                    mesConhecido--;
                } else if ((mesConhecido == MES_FEVEREIRO
                        || mesConhecido == MES_ABRIL
                        || mesConhecido == MES_JUNHO
                        || mesConhecido == MES_AGOSTO
                        || mesConhecido == MES_SETEMBRO
                        || mesConhecido == MES_NOVEMBRO)
                        && (diaConhecido == 0)) {
                    diaConhecido = NUM_DIAS_MES_31;
                    mesConhecido--;
                } else if (mesConhecido == MES_MARCO && diaConhecido == 0) {
                    if (verificaAnoBissexto(anoConhecido, anoBissexto)) {
                        diaConhecido = NUM_DIAS_MES_29;
                        mesConhecido--;

                    } else {
                        diaConhecido = NUM_DIAS_MES_28;
                        mesConhecido--;
                    }
                } else if (mesConhecido == MES_JANEIRO && diaConhecido == 0) {
                    diaConhecido = NUM_DIAS_MES_31;
                    mesConhecido = MES_DEZEMBRO;
                    anoConhecido--;
                }
            }
        }

        return diaSemana;
    }

    /**
     * Método que verifica a data recebida se está correta ou não, de acordo com
     * os padrões estabelecidos pelo cliente, e os padrões de uma data.
     *
     * @param dataRecebida Uma data para verificação
     * @param anoBissextoReferencia Ano bissexto de referência para a
     * verificação do ano bissexto e sua validação.
     *
     * @return true se estiver está correta, e false se for inválida.
     */
    //
    public static boolean verificaData(final int dataRecebida,
            final int anoBissextoReferencia) {

        String data = Integer.toString(dataRecebida);

        if (data.length() == LIMITE_CARACTERES_DATA) {

            int dia = Integer.parseInt(data.substring(LIMITE_DIA));
            int mes = Integer.parseInt(data.substring(LIMITE_MES, LIMITE_DIA));
            int ano = Integer.parseInt(data.substring(LIMITE_ANO, LIMITE_MES));

            //Verificação de dia/meses p/ cálculo de verificação do ano bissexto
            if (mes > MES_DEZEMBRO || mes < 1) {
                return false;
            } else if ((mes == MES_JANEIRO || mes == MES_MARCO
                    || mes == MES_MAIO || mes == MES_JULHO || mes == MES_AGOSTO
                    || mes == MES_OUTUBRO || mes == MES_DEZEMBRO)
                    && (dia < 1 || dia > NUM_DIAS_MES_31)) {
                return false;
            } else if ((mes == MES_ABRIL || mes == MES_JUNHO
                    || mes == MES_SETEMBRO || mes == MES_NOVEMBRO)
                    && (dia < 1 || dia > NUM_DIAS_MES_30)) {
                return false;
            } else if (mes == MES_FEVEREIRO) {
                if (verificaAnoBissexto(ano, anoBissextoReferencia)) {
                    if (dia < 1 || dia > NUM_DIAS_MES_29) {
                        return false;
                    }
                } else if (dia < 1 || dia > NUM_DIAS_MES_28) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica se o ano verificada é um ano bissexto ou não pegando como
     * referência o anoBissexto de referência.
     *
     * @param anoRecebido O ano da data desejada para verficação
     * @param anoBissextoReferencia Um numero inteiro maior que zero inserido
     * anteriormente
     *
     * @return true para é um ano bissexto ou false para não é ano bissexto
     */
    public static boolean verificaAnoBissexto(final int anoRecebido,
            final int anoBissextoReferencia) {

        int ano = anoRecebido;

        if (anoBissextoReferencia > ano) {
            while (ano < anoBissextoReferencia) {
                ano += VERIFICA_ANO_BISSEXTO_4;
            }
            return ano == anoBissextoReferencia;
        }
        if (anoBissextoReferencia < ano) {
            while (ano > anoBissextoReferencia) {
                ano -= VERIFICA_ANO_BISSEXTO_4;
            }
            return ano == anoBissextoReferencia;
        } else {
            return true;
        }
    }

    /**
     * Verifica se o dia da Semana está realmente correto com uma verificação
     * usando a classe LocalDate.
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
    public static int diaSemanaComLocalDate(final int dataDesejada,
            final int anoBissexto, final int dataConhecida,
            final int diaSemana) {

        //Separação do dia, ano e mes das respectivas datas
        String data = Integer.toString(dataDesejada);

        int dia = Integer.parseInt(data.substring(LIMITE_DIA));
        int mes = Integer.parseInt(data.substring(LIMITE_MES, LIMITE_DIA));
        int ano = Integer.parseInt(data.substring(LIMITE_ANO, LIMITE_MES));

        LocalDate a = LocalDate.of(ano, mes, dia);
        return a.getDayOfWeek().ordinal();
    }
}
