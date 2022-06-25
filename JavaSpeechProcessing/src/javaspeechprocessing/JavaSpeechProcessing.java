package javaspeechprocessing;


import javax.speech.*;
import javax.speech.synthesis.*;
import java.util.Locale;

public class JavaSpeechProcessing
{
  public static void main(String args[])
  {
    try
    {
      // Create a synthesizer for English
      Synthesizer synth = Central.createSynthesizer(
      new SynthesizerModeDesc(Locale.ENGLISH));
      synth.allocate();
      synth.resume();

      // Speak the "Hello," string
      synth.speak("I own 1999 shares of stock", null);


      // Wait till speaking is done
      synth.waitEngineState(Synthesizer.QUEUE_EMPTY);

      // release the resources
      synth.deallocate();
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}