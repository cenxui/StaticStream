package test;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

import org.junit.Test;

public class TestRamdomFileName {

	@Test
	public void test() {
		String symbolicLinkFileName = BigInteger.probablePrime(64, new SecureRandom()).toString();

		System.out.println(symbolicLinkFileName);
		
		System.out.println(UUID.randomUUID());
		
	}

}
