package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.OrderData;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    @Test
    void testAddOrder() throws Exception {
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.add(new OrderData("Espresso", List.of()));
        orderRepository.add(new OrderData("Espresso", List.of("Soy")));
        orderRepository.add(new OrderData("Espresso", List.of("Milk", "Whip")));
        orderRepository.add(new OrderData("Espresso", List.of("Soy", "Milk", "Whip")));
        orderRepository.add(new OrderData("Decaf", List.of()));
        orderRepository.add(new OrderData("Decaf", List.of("Whip")));
        orderRepository.add(new OrderData("Decaf", List.of("Whip", "Soy")));
        orderRepository.add(new OrderData("Decaf", List.of("Whip", "Soy", "Mocha")));
        orderRepository.add(new OrderData("Dark Roast", List.of()));
        orderRepository.add(new OrderData("Dark Roast", List.of("Mocha")));
        orderRepository.add(new OrderData("Dark Roast", List.of("Mocha", "Milk")));
        orderRepository.add(new OrderData("Dark Roast", List.of("Mocha", "Milk", "Soy")));
        orderRepository.add(new OrderData("houseblend", List.of()));
        orderRepository.add(new OrderData("houseblend", List.of("Milk")));
        orderRepository.add(new OrderData("houseblend", List.of("Milk", "Mocha")));
        orderRepository.add(new OrderData("houseblend", List.of("Milk", "Soy", "Mocha")));

        List<String> lines = Files.readAllLines(Path.of("db.txt"), StandardCharsets.UTF_8);
        assertTrue(lines.get(0).contains("Espresso"));
        assertTrue(lines.get(1).contains("Espresso"));
        assertTrue(lines.get(1).contains("Soy"));
        assertTrue(lines.get(2).contains("Espresso"));
        assertTrue(lines.get(2).contains("Milk"));
        assertTrue(lines.get(2).contains("Whip"));
        assertTrue(lines.get(3).contains("Espresso"));
        assertTrue(lines.get(3).contains("Soy"));
        assertTrue(lines.get(3).contains("Milk"));
        assertTrue(lines.get(3).contains("Whip"));
        assertTrue(lines.get(4).contains("Decaf"));
        assertTrue(lines.get(5).contains("Decaf"));
        assertTrue(lines.get(5).contains("Whip"));
        assertTrue(lines.get(6).contains("Decaf"));
        assertTrue(lines.get(6).contains("Whip"));
        assertTrue(lines.get(6).contains("Soy"));
        assertTrue(lines.get(7).contains("Decaf"));
        assertTrue(lines.get(7).contains("Whip"));
        assertTrue(lines.get(7).contains("Soy"));
        assertTrue(lines.get(7).contains("Mocha"));
        assertTrue(lines.get(8).contains("Dark roast"));
        assertTrue(lines.get(9).contains("Dark roast"));
        assertTrue(lines.get(9).contains("Mocha"));
        assertTrue(lines.get(10).contains("Dark roast"));
        assertTrue(lines.get(10).contains("Mocha"));
        assertTrue(lines.get(10).contains("Milk"));
        assertTrue(lines.get(11).contains("Dark roast"));
        assertTrue(lines.get(11).contains("Mocha"));
        assertTrue(lines.get(11).contains("Milk"));
        assertTrue(lines.get(11).contains("Soy"));
        assertTrue(lines.get(12).contains("HouseBlend"));
        assertTrue(lines.get(13).contains("HouseBlend"));
        assertTrue(lines.get(13).contains("Milk"));
        assertTrue(lines.get(14).contains("HouseBlend"));
        assertTrue(lines.get(14).contains("Milk"));
        assertTrue(lines.get(14).contains("Mocha"));
        assertTrue(lines.get(15).contains("HouseBlend"));
        assertTrue(lines.get(15).contains("Milk"));
        assertTrue(lines.get(15).contains("Soy"));
        assertTrue(lines.get(15).contains("Mocha"));
        try{
            orderRepository.add(new OrderData("Invalid", List.of()));
        } catch (Exception e) {
            assertEquals("Beverage type 'Invalid' is not valid!", e.getMessage());
        }
    }
}