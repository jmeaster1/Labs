package Caesar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CaesarRun {


	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Map<Integer, String> runner = new HashMap<>();
		ExecutorService ex = Executors.newCachedThreadPool();
		String string = "P SLHYULK AV WYVNYHT HA AOL ZRPSS KPZAPSSLYF";
		List<Future<String>> futures = new ArrayList<>();

		for (int j = 0; j < 26; j++) {
			Future<String> temp = ex.submit(new CaesarCipherDecrypter(string, (j + 1)));
			futures.add(temp);
		}
		ex.shutdown();

		for (int j = 0; j < futures.size(); j++) {
			runner.put((j+1), futures.get(j).get());
	
			System.out.println(runner.get(j+1));
		}
	}

}
