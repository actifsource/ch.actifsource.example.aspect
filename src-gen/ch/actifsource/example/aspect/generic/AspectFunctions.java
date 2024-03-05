package ch.actifsource.example.aspect.generic;

import ch.actifsource.util.Assert;
import java.util.List;
import ch.actifsource.core.dynamic.DynamicResourceUtil;
import ch.actifsource.core.dynamic.IDynamicResourceExtension;
import ch.actifsource.core.dynamic.IDynamicResourceExtensionJavaImpl;
import ch.actifsource.core.selector.typesystem.JavaFunctionUtil;

/* Begin Protected Region [[55616fa8-daec-11ee-97c3-13c50e3e283f,imports]] */
import java.util.ArrayList;
import ch.actifsource.core.INode;
import ch.actifsource.util.collection.CollectionUtil;
import ch.actifsource.core.javamodel.IResource;
import ch.actifsource.core.selector.typesystem.impl.TypeSystem;
import ch.actifsource.core.job.Select;
import ch.actifsource.example.aspect.literal.IOwnLiteralSelectorAspect;
import ch.actifsource.example.aspect.resource.IOwnResourceSelectorAspect;
import ch.actifsource.example.aspect.text.IOwnTextSelectorAspect;

/* End Protected Region   [[55616fa8-daec-11ee-97c3-13c50e3e283f,imports]] */

public class AspectFunctions {

  /* Begin Protected Region [[55616fa8-daec-11ee-97c3-13c50e3e283f]] */
  
  /* End Protected Region   [[55616fa8-daec-11ee-97c3-13c50e3e283f]] */


  public static interface IClassAFunctions extends IDynamicResourceExtension {

    @IDynamicResourceExtension.MethodId("69a14e67-daec-11ee-97c3-13c50e3e283f")
    public java.lang.String getOwnText();

    @IDynamicResourceExtension.MethodId("4411d6a0-daf0-11ee-97c3-13c50e3e283f")
    public List<ch.actifsource.core.javamodel.IResource> getOwnResources();

    @IDynamicResourceExtension.MethodId("63cbfed7-daf5-11ee-badc-c1e8219a3546")
    public List<java.lang.Object> getOwnLiterals();

  }
  
  public static interface IClassAFunctionsImpl extends IDynamicResourceExtensionJavaImpl {
    
    @IDynamicResourceExtension.MethodId("69a14e67-daec-11ee-97c3-13c50e3e283f")
    public java.lang.String getOwnText(final ch.actifsource.example.aspect.generic.javamodel.IClassA classA);

    @IDynamicResourceExtension.MethodId("4411d6a0-daf0-11ee-97c3-13c50e3e283f")
    public List<ch.actifsource.core.javamodel.IResource> getOwnResources(final ch.actifsource.example.aspect.generic.javamodel.IClassA classA);

    @IDynamicResourceExtension.MethodId("63cbfed7-daf5-11ee-badc-c1e8219a3546")
    public List<java.lang.Object> getOwnLiterals(final ch.actifsource.example.aspect.generic.javamodel.IClassA classA);

  }
  
  public static class ClassAFunctionsImpl implements IClassAFunctionsImpl {

    public static final IClassAFunctionsImpl INSTANCE = new ClassAFunctionsImpl();

    private ClassAFunctionsImpl() {}

    @Override
    public java.lang.String getOwnText(final ch.actifsource.example.aspect.generic.javamodel.IClassA classA) {
      /* Begin Protected Region [[69a14e67-daec-11ee-97c3-13c50e3e283f]] */
      IOwnTextSelectorAspect aspect = Select.aspect(classA.getReadJobExecutor(), classA.getResource(), IOwnTextSelectorAspect.class);
      if (aspect != null) {
        return aspect.getOwnText(classA.getReadJobExecutor(), classA.getResource());
      }
      return "Aspect is not defined";
      /* End Protected Region   [[69a14e67-daec-11ee-97c3-13c50e3e283f]] */
    }

    @Override
    public List<ch.actifsource.core.javamodel.IResource> getOwnResources(final ch.actifsource.example.aspect.generic.javamodel.IClassA classA) {
      /* Begin Protected Region [[4411d6a0-daf0-11ee-97c3-13c50e3e283f]] */
      IOwnResourceSelectorAspect aspect = Select.aspect(classA.getReadJobExecutor(), classA.getResource(), IOwnResourceSelectorAspect.class);
      if (aspect != null) {
        return TypeSystem.getCompatibleDynamicResourceRepository(classA.getReadJobExecutor()).getResources(IResource.class, 
            aspect.getOwnResources(classA.getReadJobExecutor(), classA.getResource()));
      }
      return CollectionUtil.emptyList();
      /* End Protected Region   [[4411d6a0-daf0-11ee-97c3-13c50e3e283f]] */
    }

    @Override
    public List<java.lang.Object> getOwnLiterals(final ch.actifsource.example.aspect.generic.javamodel.IClassA classA) {
      /* Begin Protected Region [[63cbfed7-daf5-11ee-badc-c1e8219a3546]] */
      IOwnLiteralSelectorAspect aspect = Select.aspect(classA.getReadJobExecutor(), classA.getResource(), IOwnLiteralSelectorAspect.class);
      if (aspect != null) {
        List<Object> result = new ArrayList<>();
        for (INode literal :aspect.getOwnLiteral(classA.getReadJobExecutor(), classA.getResource())) {
          result.add(literal.toString());
        }
        return result;
      }
      return CollectionUtil.emptyList();
      /* End Protected Region   [[63cbfed7-daf5-11ee-badc-c1e8219a3546]] */
    }

  }
  
  public static class ClassAFunctions {

    private ClassAFunctions() {}

    public static java.lang.String getOwnText(final ch.actifsource.example.aspect.generic.javamodel.IClassA classA) {
      return DynamicResourceUtil.invoke(IClassAFunctionsImpl.class, ClassAFunctionsImpl.INSTANCE, classA).getOwnText(classA);
    }

    public static List<ch.actifsource.core.javamodel.IResource> getOwnResources(final ch.actifsource.example.aspect.generic.javamodel.IClassA classA) {
      return DynamicResourceUtil.invoke(IClassAFunctionsImpl.class, ClassAFunctionsImpl.INSTANCE, classA).getOwnResources(classA);
    }

    public static List<java.lang.Object> getOwnLiterals(final ch.actifsource.example.aspect.generic.javamodel.IClassA classA) {
      return DynamicResourceUtil.invoke(IClassAFunctionsImpl.class, ClassAFunctionsImpl.INSTANCE, classA).getOwnLiterals(classA);
    }

  }

}

/* Actifsource ID=[5349246f-db37-11de-82b8-17be2e034a3b,55616fa8-daec-11ee-97c3-13c50e3e283f,Ib4c9W2RSmhe1nRl9h8Il3L0zmc=] */
