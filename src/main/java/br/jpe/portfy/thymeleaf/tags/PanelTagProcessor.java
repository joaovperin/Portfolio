/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.thymeleaf.tags;

import br.jpe.portfy.thymeleaf.Attributes;
import br.jpe.portfy.thymeleaf.Tags;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.processor.element.AbstractElementModelProcessor;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * A processor for the Panel tag
 *
 * @author joaovperin
 */
public class PanelTagProcessor extends AbstractElementModelProcessor {

    /** Name of the tag */
    private static final String TAG_NAME = "panel";
    /** Precedence */
    private static final int PRECEDENCE = 10005;

    /**
     * Constructor
     *
     * @param dialectPrefix
     */
    public PanelTagProcessor(String dialectPrefix) {
        super(TemplateMode.HTML, dialectPrefix, TAG_NAME, true, null, false, PRECEDENCE);
    }

    /**
     * Proccess the tag
     *
     * @param itc
     * @param iModel
     * @param iemsh
     */
    @Override
    protected void doProcess(ITemplateContext itc, IModel iModel, IElementModelStructureHandler iemsh) {
        IModelFactory modelFactory = itc.getModelFactory();
        iModel.replace(0, modelFactory.createOpenElementTag(Tags.DIV, Attributes.CLASS, "panel"));
        iModel.insert(1, modelFactory.createOpenElementTag(Tags.DIV, Attributes.CLASS, "contents"));
        iModel.insert(iModel.size() - 2, modelFactory.createCloseElementTag(Tags.DIV));
        iModel.replace(iModel.size() - 1, modelFactory.createCloseElementTag(Tags.DIV));
    }
}
