package eu.webdude.dsa.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CircularQueueTests {

  @Test
  void enqueue_emptyQueue_shouldAddElement() {
    CircularQueue<Integer> queue = new CircularQueue<>();

    queue.enqueue(5);

    var expectedSize = 1;
    Assertions.assertEquals(expectedSize, queue.size());
  }

  @Test
  void enqueueDeque_shouldWorkCorrectly() {
    CircularQueue<String> queue = new CircularQueue<>();
    var element = "some value";

    queue.enqueue(element);
    var elementFromQueue = queue.dequeue();

    var expectedSize = 0;
    Assertions.assertEquals(expectedSize, queue.size());
    Assertions.assertEquals(element, elementFromQueue);
  }

  @Test
  void dequeue_emptyQueue_throwsException() {
    CircularQueue<Integer> queue = new CircularQueue<>();
    assertThrows(IllegalArgumentException.class, queue::dequeue);
  }

  @Test
  void enqueueDequeue100Elements_shouldWorkCorrectly() {
    CircularQueue<Integer> queue = new CircularQueue<>();
    var numberOfElements = 1000;

    for (var i = 0; i < numberOfElements; i++) {
      queue.enqueue(i);
    }

    for (var i = 0; i < numberOfElements; i++) {
      var expectedSize = numberOfElements - i;

      Assertions.assertEquals(expectedSize, queue.size());
      int element = queue.dequeue();
      Assertions.assertEquals(i, element);

      expectedSize = numberOfElements - i - 1;
      Assertions.assertEquals(expectedSize, queue.size());
    }
  }

  @Test
  void circularQueue_enqueueDequeueManyChunks_shouldWorkCorrectly() {
    CircularQueue<Integer> queue = new CircularQueue<>();
    var chunks = 100;

    var value = 1;
    for (var i = 0; i < chunks; i++) {
      Assertions.assertEquals(0, queue.size());
      var chunkSize = i + 1;
      for (var counter = 0; counter < chunkSize; counter++) {
        Assertions.assertEquals(value - 1, queue.size());
        queue.enqueue(value);
        Assertions.assertEquals(value, queue.size());
        value++;
      }

      for (var counter = 0; counter < chunkSize; counter++) {
        value--;
        Assertions.assertEquals(value, queue.size());
        queue.dequeue();
        Assertions.assertEquals(value - 1, queue.size());
      }

      Assertions.assertEquals(0, queue.size());
    }
  }

  @Test
  void enqueue500Elements_toArray_shouldWorkCorrectly() {
    var array = new Object[500];
    for (var i = 0; i < 500; i++) {
      array[i] = i;
    }

    var queue = new CircularQueue<>();

    for (var anArray : array) {
      queue.enqueue(anArray);
    }

    var arrayFromQueue = queue.toArray();

    Assertions.assertArrayEquals(array, arrayFromQueue);
  }

  @Test
  void initialCapacity1_enqueueDequeue20Elements_shouldWorkCorrectly() {
    var elementsCount = 20;
    var initialCapacity = 1;

    CircularQueue<Integer> queue = new CircularQueue<>(initialCapacity);
    for (var i = 0; i < elementsCount; i++) {
      queue.enqueue(i);
    }

    Assertions.assertEquals(elementsCount, queue.size());
    for (var i = 0; i < elementsCount; i++) {
      int elementFromQueue = queue.dequeue();
      Assertions.assertEquals(i, elementFromQueue);
    }

    Assertions.assertEquals(0, queue.size());
  }

}
