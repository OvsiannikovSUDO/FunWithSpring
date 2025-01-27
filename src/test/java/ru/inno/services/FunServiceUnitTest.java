package ru.inno.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.inno.controllers.model.FunFactModel;
import ru.inno.repositories.FunRepo;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FunServiceUnitTest {

    @Mock
    private FunRepo funRepo;

    private FunService funService;

    @BeforeEach
    void setUp() {
        funService = new FunService(funRepo);
    }

    @Test
    void checkIfWeHaveFun() {
        Mockito.doReturn(Map.of(1L, "Fact1")).when(funRepo).getList();
        final var randomFact = funService.getRandomFact();
        assertEquals(new FunFactModel(1, "Fact1"), randomFact);
    }
}