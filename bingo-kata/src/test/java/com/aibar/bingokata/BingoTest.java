package com.aibar.bingokata;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BingoTest {


    @Test
    public void when_callANumber_then_isBetween1And75(){
       BingoCaller bingoCaller = givenQueTengoUnBingoCaller();
       Integer number = whenLlamoAUnNumero(bingoCaller);
       thenElNumeroTieneQuEstarEntre1Y75(number);
    }

    private BingoCaller givenQueTengoUnBingoCaller() {
        return new BingoCaller();
    }

    private Integer whenLlamoAUnNumero(BingoCaller bingoCaller) {
        return bingoCaller.callANumber();
    }

    private void thenElNumeroTieneQuEstarEntre1Y75(Integer number) {
        assertThat(number).isBetween(1,75);
    }

    @Test
    public void when_callNumber75Times_then_arePresentAllNumberBetween1And75(){
        BingoCaller bingoCaller = givenQueTengoUnBingoCaller();
        List<Integer> numerosLlamados = whenLLamoUnNumero75Veces(bingoCaller, 75);
        thenTodosLosNumerosDel1Al75TienenQueEstarPresentesYSerLlamadosUnaVez(numerosLlamados);
    }

    private List<Integer> whenLLamoUnNumero75Veces(BingoCaller bingoCaller, int times) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= times; ++i) {
            numbers.add(bingoCaller.callANumber());
        }
        Collections.sort(numbers);
        return numbers;
    }

    private void thenTodosLosNumerosDel1Al75TienenQueEstarPresentesYSerLlamadosUnaVez(List<Integer> numerosLlamados) {
        assertThat(numerosLlamados).hasSize(75);
        List<Integer> aComparar = new ArrayList<>();
        for (int i = 1; i <= 75; ++i) {
            aComparar.add(i);
        }
        assertThat(numerosLlamados).isEqualTo(aComparar);
    }
}
