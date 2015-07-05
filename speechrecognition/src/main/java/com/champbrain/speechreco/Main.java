package com.champbrain.speechreco;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class Main {
	private static final String ACOUSTIC_MODEL = "resource:/edu/cmu/sphinx/models/en-us/en-us";
	private static final String DICTIONARY_PATH = "resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict";
	private static final String GRAMMAR_PATH = "resource:/com/champbrain/speechreco";
	private static boolean readCommand = false;

	public static void main(String[] args) throws Exception {
		// ConfigurationManager cm = new ConfigurationManager() ;
		// cm.setGlobalProperty(ConfigurationManagerUtils.GLOBAL_COMMON_LOGLEVEL,
		// Level.SEVERE.getName());
		// ConfigurationManagerUtils.configureLogger(cm);

		Configuration configuration = new Configuration();
		configuration.setAcousticModelPath(ACOUSTIC_MODEL);
		configuration.setDictionaryPath(DICTIONARY_PATH);
		configuration.setGrammarPath(GRAMMAR_PATH);
		configuration.setUseGrammar(true);
		configuration.setGrammarName("smarthome");
		// configuration.setSampleRate(20000);
		LiveSpeechRecognizer jsgfRecognizer = new LiveSpeechRecognizer(
				configuration);
		jsgfRecognizer.startRecognition(true);
		//setDebugLevel(Level.OFF);
		SpeechUtils su = new SpeechUtils();
		su.init("kevin16");
		while (true) {

			System.out.println("###########################");
			SpeechResult result = jsgfRecognizer.getResult();
			if (null != result) {
				String resultS = result.getResult()
						.getBestFinalResultNoFiller();
				System.out.println(resultS);

				if ("smart home".equals(resultS)) {
					try {
						jsgfRecognizer.stopRecognition();
						su.speak("Yes Sir");
						jsgfRecognizer.startRecognition(true);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					readCommand = true;

				} else if (readCommand) {

					if ("switch one start".equals(resultS)
							|| "start switch one".equals(resultS)) {
						try {
							jsgfRecognizer.stopRecognition();
							su.speak(resultS);
							exec( "1" , "ON");
							jsgfRecognizer.startRecognition(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						readCommand = false;
					} else if ("switch one stop".equals(resultS)
							|| "stop switch one".equals(resultS)) {
						try {
							jsgfRecognizer.stopRecognition();
							su.speak(resultS);
							exec( "1" , "OFF");
							jsgfRecognizer.startRecognition(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						readCommand = false;
					} else if ("switch two start".equals(resultS)
							|| "start switch two".equals(resultS)) {
						try {
							jsgfRecognizer.stopRecognition();
							su.speak(resultS);
							exec( "2" , "ON");
							jsgfRecognizer.startRecognition(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						readCommand = false;
					} else if ("switch two stop".equals(resultS)
							|| "stop switch two".equals(resultS)) {
						try {
							jsgfRecognizer.stopRecognition();
							su.speak(resultS);
							exec( "2" , "OFF");
							jsgfRecognizer.startRecognition(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						readCommand = false;
					} else if ("switch three start".equals(resultS)
							|| "start switch three".equals(resultS)) {
						try {
							jsgfRecognizer.stopRecognition();
							su.speak(resultS);
							exec( "3" , "ON");
							jsgfRecognizer.startRecognition(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						readCommand = false;
					} else if ("switch three stop".equals(resultS)
							|| "stop switch three".equals(resultS)) {
						try {
							jsgfRecognizer.stopRecognition();
							su.speak(resultS);
							exec( "3" , "OFF");
							jsgfRecognizer.startRecognition(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						readCommand = false;
					} else if ("switch four start".equals(resultS)
							|| "start switch four".equals(resultS)) {
						try {
							jsgfRecognizer.stopRecognition();
							su.speak(resultS);
							exec( "4" , "ON");
							jsgfRecognizer.startRecognition(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						readCommand = false;
					} else if ("switch four stop".equals(resultS)
							|| "stop switch four".equals(resultS)) {
						try {
							jsgfRecognizer.stopRecognition();
							su.speak(resultS);
							exec( "4" , "OFF");
							jsgfRecognizer.startRecognition(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						readCommand = false;
					} else if ("switch five start".equals(resultS)
							|| "start switch five".equals(resultS)) {
						try {
							jsgfRecognizer.stopRecognition();
							su.speak(resultS);
							exec( "5" , "ON");
							jsgfRecognizer.startRecognition(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						readCommand = false;
					} else if ("switch five stop".equals(resultS)
							|| "stop switch five".equals(resultS)) {
						try {
							jsgfRecognizer.stopRecognition();
							su.speak(resultS);
							exec( "5" , "OFF");
							jsgfRecognizer.startRecognition(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						readCommand = false;
					} else if ("switch six start".equals(resultS)
							|| "start switch six".equals(resultS)) {
						try {
							jsgfRecognizer.stopRecognition();
							su.speak(resultS);
							exec( "6" , "ON");
							jsgfRecognizer.startRecognition(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						readCommand = false;
					} else if ("switch six stop".equals(resultS)
							|| "stop switch six".equals(resultS)) {
						try {
							jsgfRecognizer.stopRecognition();
							su.speak(resultS);
							exec("6","OFF");
							jsgfRecognizer.startRecognition(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						readCommand = false;
					}
				}
				jsgfRecognizer.stopRecognition();
				jsgfRecognizer.startRecognition(true);
			}

		}

		// jsgfRecognizer.stopRecognition();
	}

	private static void exec(String pin,String status) throws IOException {
		//Runtime.getRuntime().exec("sudo /home/pi/apache-tomcat-8.0.22/control-io-pin-using-args " + pin + " " + status);
	}

	public static void setDebugLevel(Level newLvl) {
		Logger anonymousLogger = LogManager.getLogManager().getLogger("");
		Handler[] handlers = anonymousLogger.getHandlers();
		anonymousLogger.setLevel(newLvl);
		for (Handler h : handlers) {
			if (h instanceof FileHandler)
				h.setLevel(newLvl);
		}
	}

}
