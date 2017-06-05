package co.nworks.swing.ReplayApp;

import java.util.List;

public class MessageProducer implements Runnable {

	enum Times {
		OneX, TwoX, FiveX
	}

	private volatile Times time = Times.OneX;

	private volatile boolean running = true;

	public Times getTime() {
		return time;
	}

	public void setTime(Times time) {
		this.time = time;
	}

	public void run() {

		try {
			List<String> data = DataSender.getData();

			if (!data.isEmpty()) {

				for (int i = 0; i < data.size(); i++) {
					while (!running) {
						Thread.yield();
					}
					switch (time) {
					case OneX:

						System.out.println(data.get(i));
						Thread.sleep(2000);
						break;

					case TwoX:
						String first = data.get(i);
						String second = null;
						if (data.size() > i + 1) {
							second = data.get(++i); // Change here
						}
						System.out.println(first);
						System.out.println(second);

						System.out.println("HELLO HI");
						Thread.sleep(2000);
						break;

					case FiveX:

						// code to get five element at one shot

						break;

					default:
						break;
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void pauseThread() throws InterruptedException {
		running = false;
	}

	public void resumeThread() {
		running = true;
	}

	public void terminate() {
		running = false;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

}
