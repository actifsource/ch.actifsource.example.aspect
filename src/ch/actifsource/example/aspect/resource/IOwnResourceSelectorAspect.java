package ch.actifsource.example.aspect.resource;

import ch.actifsource.core.INode;
import ch.actifsource.core.job.IReadJobExecutor;
import ch.actifsource.core.set.INodeList;

public interface IOwnResourceSelectorAspect {
  
  /**
   * Returns the text form the own aspect.
   */
  public INodeList getOwnResources(IReadJobExecutor executor, INode resource);

}
