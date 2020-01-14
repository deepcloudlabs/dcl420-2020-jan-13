<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output media-type="application/xml" />
	<xsl:template match="/collection/movies">
		<countries>
			<xsl:for-each select="movie[number(year) &gt; 1970 and number(year) &lt; 1980 and genres/genre='Drama']">
				<xsl:sort select="year" 
				     data-type="number" order="ascending" />
					<xsl:copy-of select="." />
			</xsl:for-each>
		</countries>
	</xsl:template>
</xsl:stylesheet>