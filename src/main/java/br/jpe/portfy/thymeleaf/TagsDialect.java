/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.thymeleaf;

import br.jpe.portfy.thymeleaf.tags.PanelTagProcessor;
import java.util.HashSet;
import java.util.Set;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * Tags custom dialect
 *
 * @author joaovperin
 */
public class TagsDialect extends AbstractProcessorDialect {

    /** Name of the dialect */
    private static final String DIALECT_NAME = "Tags Custom Dialect";
    /** Dialect prefix to be used in the view */
    private static final String DIALECT_PREFIX = "tags";

    /**
     * Constructor
     */
    public TagsDialect() {
        // We will set this dialect the same "dialect processor" precedence as
        // the Standard Dialect, so that processor executions can interleave.
        super(DIALECT_NAME, DIALECT_PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
    }

    /**
     * Return processors
     *
     * @param dialectPrefix
     * @return Set
     */
    @Override
    public Set<IProcessor> getProcessors(final String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<>();
        processors.add(new PanelTagProcessor(dialectPrefix));
        // This will remove the xmlns:score attributes we might add for IDE validation
        processors.add(new StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix));
        return processors;
    }

}
