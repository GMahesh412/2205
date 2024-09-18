/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.techdenali.promotions.conditions;


import de.hybris.platform.ruledefinitions.conditions.builders.IrConditions;
import de.hybris.platform.ruleengineservices.compiler.RuleCompilerContext;
import de.hybris.platform.ruleengineservices.compiler.RuleConditionTranslator;
import de.hybris.platform.ruleengineservices.compiler.RuleIrAttributeCondition;
import de.hybris.platform.ruleengineservices.compiler.RuleIrAttributeOperator;
import de.hybris.platform.ruleengineservices.compiler.RuleIrAttributeRelCondition;
import de.hybris.platform.ruleengineservices.compiler.RuleIrCondition;
import de.hybris.platform.ruleengineservices.compiler.RuleIrGroupCondition;
import de.hybris.platform.ruleengineservices.compiler.RuleIrGroupOperator;
import de.hybris.platform.ruleengineservices.rao.CartRAO;
import de.hybris.platform.ruleengineservices.rao.OrderEntryRAO;
import de.hybris.platform.ruleengineservices.rule.data.RuleConditionData;
import de.hybris.platform.ruleengineservices.rule.data.RuleConditionDefinitionData;
import de.hybris.platform.ruleengineservices.rule.data.RuleParameterData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomProductConditionTranslator implements RuleConditionTranslator
{
	public static final String CUSTOM_PRODUCT_PARAM = "customproduct";

	@Override
	public RuleIrCondition translate(final RuleCompilerContext context, final RuleConditionData ruleConditionData,
			final RuleConditionDefinitionData ruleConditionDefinitionData)
	{
		// retrieve cndtn parameters
		final Map<String, RuleParameterData> conditionParameters = ruleConditionData.getParameters();
		final RuleParameterData customProductParameter = conditionParameters.get(CUSTOM_PRODUCT_PARAM);

		// check if  custom product parameter is present & valid
		if (customProductParameter == null || customProductParameter.getValue() == null)
		{
			return IrConditions.empty();
		}

		final String customProductId = (String) customProductParameter.getValue();

		// ggenerate variables for OrderEntryRAO and CartRAO
		final String orderEntryRaoVariable = context.generateVariable(OrderEntryRAO.class);
		final String cartRaoVariable = context.generateVariable(CartRAO.class);

		// Create conditions
		final List<RuleIrCondition> irConditions = new ArrayList<>();

		//condition to check if  order entry products custom attribute matches the given value
		final RuleIrAttributeCondition irCustomProductCondition = new RuleIrAttributeCondition();
		irCustomProductCondition.setVariable(orderEntryRaoVariable);
		irCustomProductCondition.setAttribute("customproduct");
		irCustomProductCondition.setOperator(RuleIrAttributeOperator.EQUAL);
		irCustomProductCondition.setValue(customProductId);

		// to check if  cart contains entries with the specified customproduct attribute
		final RuleIrAttributeRelCondition irCartEntriesCondition = new RuleIrAttributeRelCondition();
		irCartEntriesCondition.setVariable(cartRaoVariable);
		irCartEntriesCondition.setAttribute("entries");
		irCartEntriesCondition.setOperator(RuleIrAttributeOperator.CONTAINS);
		irCartEntriesCondition.setTargetVariable(orderEntryRaoVariable);

		// add conditions to the list
		irConditions.add(irCustomProductCondition);
		irConditions.add(irCartEntriesCondition);

		// create  group condition with AND operator
		final RuleIrGroupCondition irGroupCondition = new RuleIrGroupCondition();
		irGroupCondition.setOperator(RuleIrGroupOperator.AND);
		irGroupCondition.setChildren(irConditions);

		return irGroupCondition;
	}
}



















 /*
  * 1st priority public class CustomProductConditionTranslator extends AbstractRuleConditionTranslator { public static
  * final String PRODUCTS_OPERATOR_PARAM = "products_operator"; private static final Log LOG =
  * LogFactory.getLog(CustomProductConditionTranslator.class); private static final String CUSTOM_PRODUCT =
  * "customproduct"; private static final String PRODUCT_CODE = "productCode";
  *
  * // main translate method
  *
  * @Override public RuleIrCondition translate(final RuleCompilerContext context, final RuleConditionData condition,
  * final RuleConditionDefinitionData conditionDefinition) {
  *
  * // retrieving condition params from the promo rule final Map<String, RuleParameterData> conditionParameters =
  * condition.getParameters(); final RuleParameterData customProductParameter = conditionParameters.get(CUSTOM_PRODUCT);
  * final RuleParameterData productsOperatorParameter = conditionParameters.get(PRODUCTS_OPERATOR_PARAM);
  *
  * // check if all req, params are present if (!verifyAllPresent(customProductParameter, productsOperatorParameter)) {
  * return IrConditions.empty(); }
  *
  * // extract values from parameters
  *
  * final String customproduct = (String) customProductParameter.getValue(); final CollectionOperator productsOperator =
  * (CollectionOperator) productsOperatorParameter.getValue();
  *
  * // validate parameters and productsOperator if (!verifyAllPresent(customproduct, productsOperator) ||
  * productsOperator != CollectionOperator.CONTAINS_ALL) { return IrConditions.empty(); }
  *
  * return getQualifyingProductsCondition(context, customproduct, productsOperator); }
  *
  * // method to create IR group condition for qualifying products protected RuleIrGroupCondition
  * getQualifyingProductsCondition(final RuleCompilerContext context, final String customproduct, final
  * CollectionOperator productsOperator) { final RuleIrGroupCondition irQualifyingProductsCondition =
  * RuleIrGroupConditionBuilder .newGroupConditionOf(RuleIrGroupOperator.AND).build();
  *
  * addQualifyingProductsCondition(context, customproduct, productsOperator, irQualifyingProductsCondition);
  *
  * return irQualifyingProductsCondition; }
  *
  *
  * // method to add qualifying products conditions to IR group condition protected void
  * addQualifyingProductsCondition(final RuleCompilerContext context, final String customproduct, final
  * CollectionOperator productsOperator, final RuleIrGroupCondition irQualifyingProductsCondition) { final String
  * orderEntryRaoVariable = context.generateVariable(OrderEntryRAO.class); final String cartRaoVariable =
  * context.generateVariable(CartRAO.class);
  *
  * final RuleIrGroupCondition baseProductOrGroupCondition = RuleIrGroupConditionBuilder
  * .newGroupConditionOf(RuleIrGroupOperator.AND).build();
  *
  *
  *
  * baseProductOrGroupCondition.getChildren()
  * .add(RuleIrAttributeConditionBuilder.newAttributeConditionFor(orderEntryRaoVariable).withAttribute(CUSTOM_PRODUCT)
  * .withOperator(RuleIrAttributeOperator.EQUAL).withValue(customproduct).build());
  *
  *
  * baseProductOrGroupCondition.getChildren()
  * .add(RuleIrAttributeRelConditionBuilder.newAttributeRelationConditionFor(cartRaoVariable).withAttribute("entries")
  * .withOperator(RuleIrAttributeOperator.CONTAINS).withTargetVariable(orderEntryRaoVariable).build());
  *
  * irQualifyingProductsCondition.getChildren().add(baseProductOrGroupCondition);
  *
  * evaluateProductsOperator(context, customproduct, productsOperator, Lists.newArrayList(customproduct),
  * irQualifyingProductsCondition, baseProductOrGroupCondition.getChildren(), orderEntryRaoVariable); }
  *
  * // method to evaluate the products ,productsOperator and adding corresponding conditions protected void
  * evaluateProductsOperator(final RuleCompilerContext context, final String customproduct, final CollectionOperator
  * productsOperator, final List<String> products, final RuleIrGroupCondition irQualifyingProductsCondition, final
  * List<RuleIrCondition> irConditions, final String orderEntryRaoVariable) {
  *
  * if (CollectionOperator.CONTAINS_ANY.equals(productsOperator)) {
  * irConditions.addAll(this.getConsumptionSupport().newProductConsumedCondition(context, orderEntryRaoVariable));
  * irQualifyingProductsCondition.getChildren().addAll(irConditions); }
  *
  * }
  *
  * private boolean verifyAllPresent(final RuleParameterData... parameters) { for (final RuleParameterData parameter :
  * parameters) { if (parameter == null || parameter.getValue() == null) { return false; } } return true; } }
  *
  *
  */





/* 2nd priority code
public class CustomProductConditionTranslator extends AbstractRuleConditionTranslator
{
	public static final String PRODUCTS_OPERATOR_PARAM = "products_operator";
	private static final Log LOG = LogFactory.getLog(CustomProductConditionTranslator.class);
	private static final String CUSTOM_PRODUCT = "customproduct";
	private static final String PRODUCT_CODE = "productCode";


	// Main translation method
	@Override
	public RuleIrCondition translate(final RuleCompilerContext context, final RuleConditionData condition,
			final RuleConditionDefinitionData conditionDefinition)
	{
		final Map<String, RuleParameterData> conditionParameters = condition.getParameters();
		final RuleParameterData customProductParameter = conditionParameters.get(CUSTOM_PRODUCT);
		final RuleParameterData productsOperatorParameter = conditionParameters.get(PRODUCTS_OPERATOR_PARAM);

		// verify all req. param's are present
		if (!verifyAllPresent(customProductParameter, productsOperatorParameter))
		{
			return IrConditions.empty();
		}

		final String customproduct = (String) customProductParameter.getValue();
		final CollectionOperator productsOperator = (CollectionOperator) productsOperatorParameter.getValue();

		// check if param's are valid & productsOperator is CONTAINS_ALL if not return empty condn.
		if (!verifyAllPresent(customproduct, productsOperator) || productsOperator != CollectionOperator.CONTAINS_ALL)
		{
			return IrConditions.empty();
		}
		// get cndtns. based on the customproduct & productsOperator
		return getQualifyingProductsCondition(context, customproduct, productsOperator);
	}

	// create group cndtn. for qualifying products
	protected RuleIrGroupCondition getQualifyingProductsCondition(final RuleCompilerContext context, final String customproduct,
			final CollectionOperator productsOperator)
	{
		final RuleIrGroupCondition irQualifyingProductsCondition = RuleIrGroupConditionBuilder
				.newGroupConditionOf(RuleIrGroupOperator.AND).build();

		addQualifyingProductsCondition(context, customproduct, productsOperator, irQualifyingProductsCondition);

		return irQualifyingProductsCondition;
	}

	// add cndtns.-> to the group condition for qualifying products
	protected void addQualifyingProductsCondition(final RuleCompilerContext context, final String customproduct,
			final CollectionOperator productsOperator, final RuleIrGroupCondition irQualifyingProductsCondition)
	{
		final String orderEntryRaoVariable = context.generateVariable(OrderEntryRAO.class);
		final String cartRaoVariable = context.generateVariable(CartRAO.class);
		final String productRaoVariable = context.generateVariable(ProductRAO.class);

		final RuleIrGroupCondition baseProductOrGroupCondition = RuleIrGroupConditionBuilder
				.newGroupConditionOf(RuleIrGroupOperator.AND).build();

		// Adding condition for customproduct attribute on Product
		if (StringUtils.isNotEmpty(customproduct))
		{
			baseProductOrGroupCondition.getChildren()
					.add(RuleIrAttributeConditionBuilder.newAttributeConditionFor(productRaoVariable).withAttribute(CUSTOM_PRODUCT)
							.withOperator(RuleIrAttributeOperator.IN).withValue(customproduct).build());
		}

		// Adding conditions for productCode attribute on OrderEntry
		baseProductOrGroupCondition.getChildren()
				.add(RuleIrAttributeConditionBuilder.newAttributeConditionFor(orderEntryRaoVariable).withAttribute(PRODUCT_CODE)
						.withOperator(RuleIrAttributeOperator.EQUAL).withValue(productRaoVariable).build());

		// Adding relation condition between Cart and OrderEntry
		baseProductOrGroupCondition.getChildren()
				.add(RuleIrAttributeRelConditionBuilder.newAttributeRelationConditionFor(cartRaoVariable).withAttribute("entries")
						.withOperator(RuleIrAttributeOperator.CONTAINS).withTargetVariable(orderEntryRaoVariable).build());

		irQualifyingProductsCondition.getChildren().add(baseProductOrGroupCondition);

		evaluateProductsOperator(context, customproduct, productsOperator, Lists.newArrayList(customproduct),
				irQualifyingProductsCondition, baseProductOrGroupCondition.getChildren(), orderEntryRaoVariable);
	}

	// evaluate the products, productsOperator & add appropriate cndtns.
	protected void evaluateProductsOperator(final RuleCompilerContext context, final String customproduct,
			final CollectionOperator productsOperator, final List<String> products,
			final RuleIrGroupCondition irQualifyingProductsCondition, final List<RuleIrCondition> irConditions,
			final String orderEntryRaoVariable)
	{
		if (CollectionOperator.CONTAINS_ANY.equals(productsOperator))
		{
			irConditions.addAll(getConsumptionSupport().newProductConsumedCondition(context, orderEntryRaoVariable));
		}
		else if (CollectionOperator.NOT_CONTAINS.equals(productsOperator))
		{
			final RuleIrNotCondition irNotProductCondition = new RuleIrNotCondition();
			irNotProductCondition.setChildren(irConditions);
			irQualifyingProductsCondition.getChildren().add(irNotProductCondition);
		}
		else
		{
			irQualifyingProductsCondition.getChildren().addAll(irConditions);
			if (CollectionOperator.CONTAINS_ALL.equals(productsOperator))
			{
				addContainsAllProductsConditions(context, customproduct, products, irQualifyingProductsCondition);
			}
		}
	}

	// add cndtns. for all products if the productsOperator is CONTAINS_ALL
	protected void addContainsAllProductsConditions(final RuleCompilerContext context, final String customproduct,
			final List<String> products, final RuleIrGroupCondition irQualifyingProductsCondition)
	{
		final String cartRaoVariable = context.generateVariable(CartRAO.class);

		for (final String product : products)
		{
			final RuleIrLocalVariablesContainer variablesContainer = context.createLocalContainer();
			final String containsOrderEntryRaoVariable = context.generateLocalVariable(variablesContainer, OrderEntryRAO.class);
			final List<RuleIrCondition> irConditions = Lists.newArrayList();

			irConditions.add(RuleIrAttributeConditionBuilder.newAttributeConditionFor(containsOrderEntryRaoVariable)
					.withAttribute(PRODUCT_CODE).withOperator(RuleIrAttributeOperator.EQUAL).withValue(product).build());

			irConditions.add(RuleIrAttributeConditionBuilder.newAttributeConditionFor(containsOrderEntryRaoVariable)
					.withAttribute(CUSTOM_PRODUCT).withOperator(RuleIrAttributeOperator.CONTAINS).withValue(customproduct).build());

			irConditions
					.add(RuleIrAttributeRelConditionBuilder.newAttributeRelationConditionFor(cartRaoVariable).withAttribute("entries")
							.withOperator(RuleIrAttributeOperator.CONTAINS).withTargetVariable(containsOrderEntryRaoVariable).build());

			irConditions.addAll(getConsumptionSupport().newProductConsumedCondition(context, containsOrderEntryRaoVariable));

			final RuleIrExistsCondition irExistsProductCondition = new RuleIrExistsCondition();
			irExistsProductCondition.setVariablesContainer(variablesContainer);
			irExistsProductCondition.setChildren(irConditions);

			irQualifyingProductsCondition.getChildren().add(irExistsProductCondition);
		}
	}


	//Utility method to check if all required parameters are present
	private boolean verifyAllPresent(final RuleParameterData... parameters)
	{
		for (final RuleParameterData parameter : parameters)
		{
			if (parameter == null || parameter.getValue() == null)
			{
				return false;
			}
		}
		return true;
	}
}
*/


/*
 * 1st priority code public class CustomProductConditionTranslator extends AbstractRuleConditionTranslator { public
 * static final String PRODUCTS_OPERATOR_PARAM = "products_operator"; private static final Log LOG =
 * LogFactory.getLog(CustomProductConditionTranslator.class); private static final String CUSTOM_PRODUCT =
 * "customproduct"; private static final String PRODUCT_CODE = "productCode";
 *
 * @Override public RuleIrCondition translate(final RuleCompilerContext context, final RuleConditionData condition,
 * final RuleConditionDefinitionData conditionDefinition) { final Map<String, RuleParameterData> conditionParameters =
 * condition.getParameters(); final RuleParameterData customProductParameter = conditionParameters.get("customproduct");
 * final RuleParameterData productsOperatorParameter = conditionParameters.get("products_operator");
 *
 * // Checking if all parameters are available if (!verifyAllPresent(customProductParameter, productsOperatorParameter))
 * { return IrConditions.empty(); }
 *
 * final String customproduct = (String) customProductParameter.getValue(); final CollectionOperator productsOperator =
 * (CollectionOperator) productsOperatorParameter.getValue();
 *
 * if (!verifyAllPresent(customproduct, productsOperator)) { return IrConditions.empty(); }
 *
 * return getQualifyingProductsCondition(context, customproduct, productsOperator); }
 *
 * protected RuleIrGroupCondition getQualifyingProductsCondition(final RuleCompilerContext context, final String
 * customproduct, final CollectionOperator productsOperator) { final RuleIrGroupCondition irQualifyingProductsCondition
 * = RuleIrGroupConditionBuilder .newGroupConditionOf(RuleIrGroupOperator.AND).build();
 *
 * addQualifyingProductsCondition(context, customproduct, productsOperator, irQualifyingProductsCondition);
 *
 * return irQualifyingProductsCondition; }
 *
 * protected void addQualifyingProductsCondition(final RuleCompilerContext context, final String customproduct, final
 * CollectionOperator productsOperator, final RuleIrGroupCondition irQualifyingProductsCondition) { final String
 * orderEntryRaoVariable = context.generateVariable(OrderEntryRAO.class); final String cartRaoVariable =
 * context.generateVariable(CartRAO.class); final String productRaoVariable =
 * context.generateVariable(ProductRAO.class); final List<RuleIrCondition> irConditions = Lists.newArrayList();
 *
 * final RuleIrGroupCondition baseProductOrGroupCondition = RuleIrGroupConditionBuilder
 * .newGroupConditionOf(RuleIrGroupOperator.AND).build();
 *
 * // Adding condition for customproduct attribute on Product if (StringUtils.isNotEmpty(customproduct)) {
 * baseProductOrGroupCondition.getChildren()
 * .add(RuleIrAttributeConditionBuilder.newAttributeConditionFor(productRaoVariable).withAttribute(CUSTOM_PRODUCT)
 * .withOperator(RuleIrAttributeOperator.IN).withValue(customproduct).build()); }
 *
 * // Adding conditions for productCode attribute on OrderEntry
 *
 * baseProductOrGroupCondition.getChildren()
 * .add(RuleIrAttributeConditionBuilder.newAttributeConditionFor(orderEntryRaoVariable).withAttribute(PRODUCT_CODE)
 * .withOperator(RuleIrAttributeOperator.IN).withValue(productRaoVariable).build());
 *
 *
 * // Adding relation condition between Cart and OrderEntry baseProductOrGroupCondition.getChildren()
 * .add(RuleIrAttributeRelConditionBuilder.newAttributeRelationConditionFor(cartRaoVariable).withAttribute("entries")
 * .withOperator(RuleIrAttributeOperator.CONTAINS).withTargetVariable(orderEntryRaoVariable).build());
 *
 * irConditions.add(baseProductOrGroupCondition);
 *
 * // Adding condition for customproduct with specified operator if (productsOperator != null) { irConditions
 * .add(RuleIrAttributeConditionBuilder.newAttributeConditionFor(productRaoVariable).withAttribute(CUSTOM_PRODUCT)
 * .withOperator(RuleIrAttributeOperator.CONTAINS).withValue(customproduct).build()); }
 *
 * irQualifyingProductsCondition.getChildren().addAll(irConditions); }
 *
 *
 * protected void evaluateProductsOperator(final RuleCompilerContext context, final String customproduct, final
 * CollectionOperator productsOperator, final List<String> products, final RuleIrGroupCondition
 * irQualifyingProductsCondition, final List<RuleIrCondition> irConditions, final String orderEntryRaoVariable) { if
 * (CollectionOperator.CONTAINS_ANY.equals(productsOperator)) {
 * irConditions.addAll(getConsumptionSupport().newProductConsumedCondition(context, orderEntryRaoVariable)); } else if
 * (CollectionOperator.NOT_CONTAINS.equals(productsOperator)) { final RuleIrNotCondition irNotProductCondition = new
 * RuleIrNotCondition(); irNotProductCondition.setChildren(irConditions);
 * irQualifyingProductsCondition.getChildren().add(irNotProductCondition); } else {
 * irQualifyingProductsCondition.getChildren().addAll(irConditions); if
 * (CollectionOperator.CONTAINS_ALL.equals(productsOperator)) { addContainsAllProductsConditions(context, customproduct,
 * products, irQualifyingProductsCondition); } } }
 *
 * protected void addContainsAllProductsConditions(final RuleCompilerContext context, final String customproduct, final
 * List<String> products, final RuleIrGroupCondition irQualifyingProductsCondition) { final String cartRaoVariable =
 * context.generateVariable(CartRAO.class);
 *
 * for (final String product : products) { final RuleIrLocalVariablesContainer variablesContainer =
 * context.createLocalContainer(); final String containsOrderEntryRaoVariable =
 * context.generateLocalVariable(variablesContainer, OrderEntryRAO.class); final List<RuleIrCondition> irConditions =
 * Lists.newArrayList();
 *
 * irConditions.add(RuleIrAttributeConditionBuilder.newAttributeConditionFor(containsOrderEntryRaoVariable)
 * .withAttribute(PRODUCT_CODE).withOperator(RuleIrAttributeOperator.EQUAL).withValue(product).build());
 *
 * irConditions.add(RuleIrAttributeConditionBuilder.newAttributeConditionFor(containsOrderEntryRaoVariable)
 * .withAttribute(CUSTOM_PRODUCT).withOperator(RuleIrAttributeOperator.valueOf(productsOperator.name()))
 * .withValue(customproduct).build());
 *
 * irConditions
 * .add(RuleIrAttributeRelConditionBuilder.newAttributeRelationConditionFor(cartRaoVariable).withAttribute("entries")
 * .withOperator(RuleIrAttributeOperator.CONTAINS).withTargetVariable(containsOrderEntryRaoVariable).build());
 *
 * irConditions.addAll(getConsumptionSupport().newProductConsumedCondition(context, containsOrderEntryRaoVariable));
 *
 * final RuleIrExistsCondition irExistsProductCondition = new RuleIrExistsCondition();
 * irExistsProductCondition.setVariablesContainer(variablesContainer);
 * irExistsProductCondition.setChildren(irConditions);
 *
 * irQualifyingProductsCondition.getChildren().add(irExistsProductCondition); } }
 *
 * // Utility method to check if all required parameters are present private boolean verifyAllPresent(final
 * RuleParameterData... parameters) { for (final RuleParameterData parameter : parameters) { if (parameter == null ||
 * parameter.getValue() == null) { return false; } } return true; } }
 */