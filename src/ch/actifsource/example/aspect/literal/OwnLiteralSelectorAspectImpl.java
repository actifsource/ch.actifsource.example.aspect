package ch.actifsource.example.aspect.literal;

import java.util.List;
import ch.actifsource.core.INode;
import ch.actifsource.core.job.IReadJobExecutor;
import ch.actifsource.core.model.aspects.ILinkSelectorRelationAspectFactory;
import ch.actifsource.core.model.aspects.IResourceValidationAspect;
import ch.actifsource.core.selector.SelectSelectorUtil;
import ch.actifsource.core.selector.SelectorPackage;
import ch.actifsource.core.selector.element.ILinkSelector;
import ch.actifsource.core.set.INodeList;
import ch.actifsource.core.set.NodeList;
import ch.actifsource.core.validation.ValidationContext;
import ch.actifsource.core.validation.inconsistency.IResourceInconsistency;

public class OwnLiteralSelectorAspectImpl  implements IOwnLiteralSelectorAspect, IResourceValidationAspect {

	public final static ILinkSelectorRelationAspectFactory<OwnLiteralSelectorAspectImpl> FACTORY;

	static {
		FACTORY = new ILinkSelectorRelationAspectFactory<OwnLiteralSelectorAspectImpl>() {

			@Override
			public Class<OwnLiteralSelectorAspectImpl> getAspectClass() {
				return OwnLiteralSelectorAspectImpl.class;
			}

			@Override
			public OwnLiteralSelectorAspectImpl create(ILinkSelector selector) {
				return new OwnLiteralSelectorAspectImpl(selector);
			}
		};
	}

	private final ILinkSelector fLinkSelector;
	
	public OwnLiteralSelectorAspectImpl(ILinkSelector linkSelector) {
	  fLinkSelector = linkSelector;
	}

	@Override
	public INodeList getOwnLiteral(IReadJobExecutor executor, INode resource) {
	  INodeList result = SelectSelectorUtil.selectSelectorNodesOrNull(executor, fLinkSelector.getElementId(),  new NodeList(SelectorPackage.ModelSingleton, resource));
    if (result != null) return result;
    return NodeList.EMPTY_LIST;
	}

  @Override
  public void validate(ValidationContext context, List<IResourceInconsistency> inconsistencyList) {
    // Own validation function
  }

}
