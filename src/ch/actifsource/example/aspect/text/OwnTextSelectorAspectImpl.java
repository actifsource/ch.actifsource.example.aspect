package ch.actifsource.example.aspect.text;

import java.util.List;

import ch.actifsource.core.INode;
import ch.actifsource.core.job.IReadJobExecutor;
import ch.actifsource.core.model.aspects.ILinkSelectorRelationAspectFactory;
import ch.actifsource.core.model.aspects.IResourceValidationAspect;
import ch.actifsource.core.selector.SelectSelectorUtil;
import ch.actifsource.core.selector.element.ILinkSelector;
import ch.actifsource.core.validation.ValidationContext;
import ch.actifsource.core.validation.inconsistency.IResourceInconsistency;
import ch.actifsource.util.character.StringUtil;

public class OwnTextSelectorAspectImpl implements IOwnTextSelectorAspect, IResourceValidationAspect {

	public final static ILinkSelectorRelationAspectFactory<OwnTextSelectorAspectImpl> FACTORY;

	static {
		FACTORY = new ILinkSelectorRelationAspectFactory<OwnTextSelectorAspectImpl>() {

			@Override
			public Class<OwnTextSelectorAspectImpl> getAspectClass() {
				return OwnTextSelectorAspectImpl.class;
			}

			@Override
			public OwnTextSelectorAspectImpl create(ILinkSelector selector) {
				return new OwnTextSelectorAspectImpl(selector);
			}
		};
	}

	private final ILinkSelector fLinkSelector;
	
	public OwnTextSelectorAspectImpl(ILinkSelector linkSelector) {
	  fLinkSelector = linkSelector;
	}

	@Override
	public String getOwnText(IReadJobExecutor executor, INode resource) {
	  return StringUtil.nullToEmptyString(SelectSelectorUtil.selectSelectorTextOrNull(executor, fLinkSelector.getElementId(), resource));
	}

  @Override
  public void validate(ValidationContext arg0, List<IResourceInconsistency> arg1) {
    // Own validation function
  }

}
