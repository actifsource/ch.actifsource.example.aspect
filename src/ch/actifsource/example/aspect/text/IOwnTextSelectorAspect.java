package ch.actifsource.example.aspect.text;

import ch.actifsource.core.INode;
import ch.actifsource.core.job.IReadJobExecutor;

public interface IOwnTextSelectorAspect {
	
  /**
   * Returns the text form the own aspect.
   */
  public String getOwnText(IReadJobExecutor executor, INode resource);

}
