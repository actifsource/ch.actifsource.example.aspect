package ch.actifsource.example.aspect.resource;

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

public class OwnResourceSelectorAspectImpl implements IOwnResourceSelectorAspect, IResourceValidationAspect {

	public final static ILinkSelectorRelationAspectFactory<OwnResourceSelectorAspectImpl> FACTORY;

	static {
		FACTORY = new ILinkSelectorRelationAspectFactory<OwnResourceSelectorAspectImpl>() {

			@Override
			public Class<OwnResourceSelectorAspectImpl> getAspectClass() {
				return OwnResourceSelectorAspectImpl.class;
			}

			@Override
			public OwnResourceSelectorAspectImpl create(ILinkSelector selector) {
				return new OwnResourceSelectorAspectImpl(selector);
			}
		};
	}

	private final ILinkSelector fLinkSelector;
	
	public OwnResourceSelectorAspectImpl(ILinkSelector linkSelector) {
	  fLinkSelector = linkSelector;
	}

	@Override
	public INodeList getOwnResources(IReadJobExecutor executor, INode resource) {
	  INodeList result = SelectSelectorUtil.selectSelectorNodesOrNull(executor, fLinkSelector.getElementId(),  new NodeList(SelectorPackage.ModelSingleton, resource));
	  if (result != null) return result;
	  return NodeList.EMPTY_LIST;
	}

  @Override
  public void validate(ValidationContext arg0, List<IResourceInconsistency> arg1) {
    // Own validation function
  }

}
