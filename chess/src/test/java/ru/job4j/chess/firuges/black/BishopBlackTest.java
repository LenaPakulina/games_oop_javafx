package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {
    @Test
    void checkPositionFunc() {
        Cell position = Cell.C1;
        BishopBlack figure = new BishopBlack(position);
        assertThat(figure.position()).isEqualTo(position);
    }

    @Test
    void checkCopyFunc() {
        Cell position1 = Cell.A1;
        Cell position2 = Cell.F2;
        BishopBlack figure = new BishopBlack(position1);
        Figure item = figure.copy(position2);
        assertThat(item.position()).isEqualTo(position2);
    }

    @Test
    void checkWayFunc() {
        Cell position = Cell.C1;
        BishopBlack figure = new BishopBlack(position);
        Cell[] correctWay = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(correctWay).isEqualTo(figure.way(Cell.G5));
    }

    @Test
    void checkWayFuncWhenDiagonalStep() {
        Cell source = Cell.C1;
        Cell destination = Cell.G5;
        BishopBlack figure = new BishopBlack(source);
        Cell[] correctWay = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] ways = figure.way(destination);
        assertThat(correctWay).isEqualTo(ways);
    }

    @Test
    void checkWayFuncWhenNonDiagonalStep() {
        Cell source = Cell.C1;
        Cell destination = Cell.F8;
        BishopBlack figure = new BishopBlack(source);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    figure.way(destination);
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to F8");
    }
}