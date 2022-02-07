package com.sbrf.reboot.concurrentmodify;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveElementWithoutErrorsTest {

    @Test
    public void successConcurrentModificationException() {

        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        assertThrows(ConcurrentModificationException.class, () -> {
            
            for (Integer integer : list) {
                list.remove(1);
            }
            
        });

    }

    @Test
    public void successRemoveElementWithoutErrors() {
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        list.removeIf(val -> val == 1);

        assertEquals(list.size(), 2);
    }

    @Test
    public void SuccessRemoveElementWithStoreWithoutErrors(){
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};
        
        List<Integer> found = new ArrayList<>();

        for (Integer item: list) {
            if (item == 1) {
                found.add(item);
            }
        }

        list.removeAll(found);

        assertEquals(list.size(), 2);
    }

    @Test
    public void SuccessRemoveElementWithIteratorsWithoutErrors(){
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        ListIterator<Integer> iterator = list.listIterator();

        while(iterator.hasNext()) {
            if (iterator.next() == 1) {
                iterator.remove();
            }
        }

        assertEquals(list.size(), 2);
    }

}
