package ch.actifsource.example.aspect.literal;

import ch.actifsource.core.INode;
import ch.actifsource.core.job.IReadJobExecutor;
import ch.actifsource.core.set.INodeList;

public interface IOwnLiteralSelectorAspect {
  
  /**
   * Returns the literal form the own aspect.
   */
  public INodeList getOwnLiteral(IReadJobExecutor executor, INode resource);

}
