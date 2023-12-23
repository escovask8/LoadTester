package com.example.demo;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LoadTestServiceTest {
	
    @Test
    public void testRunLoadTestSuccess() {
        // Criar instância de LoadTestService
        LoadTestService loadTestService = new LoadTestService();

        // Definir URLs de teste
        List<String> urls = Arrays.asList("http://example.com", "http://example.org");

        // Executar teste
        LoadTestResult result = loadTestService.runLoadTest(urls, 10, 1);

        // Verificar resultados esperados
        assertEquals(20, result.getSuccesses()); // Supondo que cada URL gera 2 sucessos
        assertEquals(0, result.getFailures());
        // Adicionar mais verificações conforme necessário
    }

    @Test
    public void testRunLoadTestFailure() {
        // Criar instância de LoadTestService
        LoadTestService loadTestService = new LoadTestService();

        // Definir URLs inválidas de propósito
        List<String> urls = Arrays.asList("http://invalid-url", "http://example.org");

        // Executar teste
        LoadTestResult result = loadTestService.runLoadTest(urls, 10, 1);

        // Verificar resultados esperados
        assertEquals(10, result.getSuccesses()); // Supondo que cada URL gera 1 sucesso
        assertEquals(10, result.getFailures());
        // Adicionar mais verificações conforme necessário
    }
}