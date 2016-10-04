
import com.github.natalialopessilva.cs20162.aula07.DiaDaSemana;
import static com.github.natalialopessilva.cs20162.aula07.DiaDaSemana.diaSemana;
import static com.github.natalialopessilva.cs20162.aula07.DiaDaSemana.diaSemanaComLocalDate;
import org.junit.Assert;
import org.junit.Test;

public class DiaDaSemanaTest {

    /**
     * Implementação dos Testes referentes a classe DiaSemana
     *
     * <p>
     * Testes implementados com base nos testes propostos na lista explicativa
     * do algoritmo
     *
     */
    @Test
    public void dataDesejadaCaracteresAMenos() {
        Assert.assertEquals(-1, diaSemana(2010101, 2016, 20160202, 1));
    }

    @Test
    public void dataDesejadaCaracteresAMais() {
        Assert.assertEquals(-1, diaSemana(100000101, 2016, 20160202, 1));
    }

    @Test
    public void dataDesejadaMesIncorreto() {
        Assert.assertEquals(-1, diaSemana(20161301, 2016, 20160202, 1));
    }

    @Test
    public void dataDesejadaMesZero() {
        Assert.assertEquals(-1, diaSemana(20160001, 2016, 20160202, 1));
    }

    @Test
    public void dataDesejadaDiaIncorreto() {
        Assert.assertEquals(-1, diaSemana(20160931, 2016, 20160202, 1));
    }

    @Test
    public void dataDesejadaDiaFevereiroIncorretoParaBissexto() {
        Assert.assertEquals(-1, diaSemana(20150229, 2016, 20160202, 1));
    }

    @Test
    public void dataDesejadaDiaZero() {
        Assert.assertEquals(-1, diaSemana(20160900, 2016, 20160202, 1));
    }

    @Test
    public void dataConhecidaCaracteresAMenos() {
        Assert.assertEquals(-1, diaSemana(20160202, 2016, 2010101, 1));
    }

    @Test
    public void dataConhecidaCaracteresAMais() {
        Assert.assertEquals(-1, diaSemana(20160202, 2016, 100000101, 1));
    }

    @Test
    public void dataConhecidaMesIncorreto() {
        Assert.assertEquals(-1, diaSemana(20160202, 2016, 20161301, 1));
    }

    @Test
    public void dataConhecidaMesZero() {
        Assert.assertEquals(-1, diaSemana(20160202, 2016, 20160001, 1));
    }

    @Test
    public void dataConhecidaDiaIncorreto() {
        Assert.assertEquals(-1, diaSemana(20160202, 2016, 20160931, 1));
    }

    @Test
    public void dataConhecidaDiaFevereiroIncorretoParaBissexto() {
        Assert.assertEquals(-1, diaSemana(20160202, 2016, 20150229, 1));
    }

    @Test
    public void dataConhecidaDiaZero() {
        Assert.assertEquals(-1, diaSemana(20160202, 2016, 20160900, 1));
    }

    @Test
    public void anoBissextoZero() {
        Assert.assertEquals(-1, diaSemana(20160202, 0, 20160202, 1));
    }

    @Test
    public void anoBissextoMenorQueZero() {
        Assert.assertEquals(-1, diaSemana(20160202, -100, 20160202, 1));
    }

    @Test
    public void diaSemanaConhecidoMenorQueZero() {
        Assert.assertEquals(-1, diaSemana(20160202, 2016, 20160202, -1));
    }

    @Test
    public void diaSemanaConhecidoMaiorQueSeis() {
        Assert.assertEquals(-1, diaSemana(20160202, 2016, 20160202, 7));
    }

    @Test
    public void saidaEsperadaCorretaMesmaData() {
        Assert.assertEquals(3, diaSemana(20160928, 2016, 20160928, 3));
    }

    @Test
    public void saidaEsperadaCorretaDatasDiferentes() {
        Assert.assertEquals(3, diaSemana(20160928, 2016, 20160901, 4));
    }
    
    @Test
    public void saidaEsperadaCorretaDatasDiferentes2() {
        Assert.assertEquals(4, diaSemana(20160901, 2016, 20160928, 3));
    }

    @Test// Teste de saídas entre algoritmo manuel e utilicação da classe LocalDate
    public void saidaEsperadaCorretaLocalDate() {
        Assert.assertEquals(diaSemana(20160929, 2000, 20160928, 2), diaSemanaComLocalDate(20160929, 2000, 20160928, 2));
    }

    /** 
     * Testes para obter 100% de cobertura
     */
    
    @Test
    public void cemPorCentoCobertura() {
        new DiaDaSemana();
    }

    //Cem por cento de cobertura na primeira condicional (primeiro while inclusive)
    @Test
    public void cemPorCentoCoberturaDiaSemana1() {
        Assert.assertEquals(3, diaSemana(20160928, 2016, 20160901, 4));
    }

    @Test
    public void cemPorCentoCoberturaDiaSemana2() {
        Assert.assertEquals(3, diaSemana(20160928, 2016, 20160731, 0));
    }

    @Test
    public void cemPorCentoCoberturaDiaSemana3() {
        Assert.assertEquals(3, diaSemana(20160928, 2016, 20150101, 4));
    }
    
    //Cem por cento de cobertura na segunda condicional (segundo while inclusive)
    @Test 
    public void cemPorCentoCoberturaDiaSemana4() {
        Assert.assertEquals(4, diaSemana(20150101, 2016, 20160928, 3));
    }

    @Test //Caso em que o ano conhecido é maior que o desejado
    public void cemPorCentoCoberturaDiaSemana5() {
        Assert.assertEquals(6, diaSemana(20151010, 2016, 20160928, 3));
    }

    @Test//Caso em que o ano conhecido é igual ao ano desejado mas o mes é maior
    public void cemPorCentoCoberturaDiaSemana6() {
        Assert.assertEquals(0, diaSemana(20160731, 2016, 20160928, 3));
    }

    @Test//Caso em que o ano conhecido é igual ao ano desejado mas o mes é maior
    public void cemPorCentoCoberturaDiaSemana7() {
        Assert.assertEquals(2, diaSemana(20160927, 2016, 20160928, 3));
    }

    @Test//Caso em que o ano conhecido é igual ao ano desejado mas o mes é maior
    public void cemPorCentoCoberturaDiaSemana8() {
        Assert.assertEquals(6, diaSemana(20160702, 2016, 20160928, 3));
    }

    @Test//Caso em que os anos são iguais, os meses são iguais mas o dia conhecido é maior que o desejado
    public void cemPorCentoCoberturaDiaSemana9() {
        Assert.assertEquals(4, diaSemana(20160901, 2016, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaDiaSemana10() {
        Assert.assertEquals(4, diaSemana(20150101, 2000, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaDiaSemana11() {
        Assert.assertEquals(0, diaSemana(20160731, 2000, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaDiaSemana12() {
        Assert.assertEquals(0, diaSemana(20120101, 2016, 20160928, 3));
    }

    //cem por cento cobertura nas verificações onde a saida será incorreta
    @Test
    public void cemPorCentoCoberturaDiaSemanaSaidaIncorreta1() {
        Assert.assertEquals(-1, diaSemana(20160332, 2016, 20160900, 1));
    }

    @Test
    public void cemPorCentoCoberturaDiaSemanaSaidaIncorreta2() {
        Assert.assertEquals(-1, diaSemana(20160230, 2016, 20160900, 1));
    }

    @Test
    public void cemPorCentoCoberturaDiaSemanaSaidaIncorreta3() {
        Assert.assertEquals(-1, diaSemana(20160200, 2016, 20160900, 1));
    }

    @Test
    public void cemPorCentoCoberturaDiaSemanaSaidaIncorreta4() {
        Assert.assertEquals(-1, diaSemana(20150200, 2000, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaDiaSemanaSaidaIncorreta5() {
        Assert.assertEquals(-1, diaSemana(20150230, 2000, 20160928, 3));
    }

    //cem por cento cobertura no método verificaData
    @Test
    public void cemPorCentoCoberturaValidaDataMes01() {
        Assert.assertEquals(0, diaSemana(20120101, 2016, 20160928, 3));
    }

    @Test// caso de inválidez de data
    public void cemPorCentoCoberturaValidaDataMes02() {
        Assert.assertEquals(-1, diaSemana(20120235, 2016, 20160928, 3));
    }

    @Test// caso de inválidez de data
    public void cemPorCentoCoberturaValidaDataMes03() {
        Assert.assertEquals(-1, diaSemana(20120300, 2016, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaValidaDataMes04() {
        Assert.assertEquals(0, diaSemana(20120401, 2016, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaValidaDataMes05() {
        Assert.assertEquals(2, diaSemana(20120501, 2016, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaValidaDataMes06() {
        Assert.assertEquals(5, diaSemana(20120601, 2016, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaValidaDataMes07() {
        Assert.assertEquals(0, diaSemana(20120701, 2016, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaValidaDataMes08() {
        Assert.assertEquals(3, diaSemana(20120801, 2016, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaValidaDataMes09() {
        Assert.assertEquals(6, diaSemana(20120901, 2016, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaValidaDataMes10() {
        Assert.assertEquals(1, diaSemana(20121001, 2016, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaValidaDataMes11() {
        Assert.assertEquals(4, diaSemana(20121101, 2016, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaValidaDataMes12() {
        Assert.assertEquals(6, diaSemana(20121201, 2016, 20160928, 3));
    }

    //cem por cento cobertura nos casos de dados incorretos para o método validaData
    @Test
    public void cemPorCentoCoberturaValidaDataIncorreto() {
        Assert.assertEquals(-1, diaSemana(20140200, 2016, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaValidaDataIncorreto2() {
        Assert.assertEquals(-1, diaSemana(20140230, 2016, 20160928, 3));
    }

    @Test
    public void cemPorCentoCoberturaValidaDataIncorreto3() {
        Assert.assertEquals(-1, diaSemana(20140202, 2016, 20140232, 3));
    }

    @Test
    public void cemPorCentoCoberturaValidaDataIncorreto4() {
        Assert.assertEquals(-1, diaSemana(20140202, 2016, 20140200, 3));
    }

    @Test
    public void cemPorCentoCoberturaValidaDataIncorreto5() {
        Assert.assertEquals(-1, diaSemana(20000202, 2016, 20000200, 3));
    }
}
