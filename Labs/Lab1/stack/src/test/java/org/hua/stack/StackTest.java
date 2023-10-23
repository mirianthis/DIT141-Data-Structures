/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.stack;


public class StackTest {
    	@Test
	public void testArrayStack() {
		checkStack(new ArrayStack<>());
	}

	@Test
	public void testLinkedStack() {
		checkStack(new LinkedStack<>());
	}

	private void checkStack(stack<Integer> s) {
		s.clear();

		int count = 100000;

		for (int i = 0; i < count; i++) {
			s.push(i);
			assertTrue(s.size() == i + 1);
			assertTrue(s.top() == i);
		}

		int current = count - 1;
		while (!s.isEmpty()) {
			assertTrue(s.top() == current);
			s.pop();
			current--;
		}
		assertTrue(s.isEmpty());
	}

    
}
