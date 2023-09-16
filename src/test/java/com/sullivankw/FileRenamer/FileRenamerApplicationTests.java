package com.sullivankw.FileRenamer;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FileRenamerServiceTest {

	@Autowired
	private FileRenameService classUnderTest;

	@Nested
	class FileRenameServiceTests {
		@Test
		void givenDirectoryDoesNotExist_thenThrowIllegalArgumentException() {
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				classUnderTest.reverse("fake-dir", "png");
			});
			assertTrue(exception.getMessage().contains("fake-dir was not found"));
		}
	}
}
