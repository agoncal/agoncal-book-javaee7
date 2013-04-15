<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                exclude-result-prefixes="#all" version="2.0">
  <xsl:output indent="yes"/>
  <xsl:param name="unitPrices" as="xs:double*"/>
  <xsl:param name="quantities" as="xs:integer*"/>
  <xsl:param name="itemNames" as="xs:string*"/>
  <xsl:param name="orderID" as="xs:string"/>

  <xsl:template name="getXMLOrder">
    <xsl:if test="count($unitPrices) != count($itemNames)
            or count($unitPrices) != count($quantities)">
      <xsl:value-of select="error((), 'Wrong parameters.')"/>
    </xsl:if>
    <xsl:variable name="nbLines" select="count($itemNames)"/>

    <order id="{$orderID}" date="{current-date()}"
           total_amount="{sum( for $i in (1 to $nbLines)
                            return $unitPrices[$i] * $quantities[$i])}">
      <customer first_name="James" last_name="Rorrison">
        <email>j.rorri@me.com</email>
        <phoneNumber>+44 1234 1234</phoneNumber>
      </customer>
      <content>

        <xsl:for-each select="1 to $nbLines">
          <xsl:variable name="rang" select="."/>
          <order_line item="{$itemNames[$rang]}">
            <unit_price>
              <xsl:value-of select="$unitPrices[$rang]"/>
            </unit_price>
            <quantity>
              <xsl:value-of select="$quantities[$rang]"/>
            </quantity>
          </order_line>
        </xsl:for-each>

      </content>
      <credit_card number="123412341234">
        <expiry_date>10/13</expiry_date>
        <control_number>234</control_number>
        <type>Visa</type>
      </credit_card>
    </order>

  </xsl:template>
</xsl:stylesheet>