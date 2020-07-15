package com.contable.app.contables;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class DownloadBalance {
	
	private static final File tempDirectory = new File(System.getProperty("java.io.tmpdir"));
		
	public static void Download(List<Contables> contables, String name) throws FileNotFoundException, DocumentException {
	    Document document = new Document(PageSize.A4, 0, 0, 0, 0);
	    PdfWriter.getInstance(document, new FileOutputStream(tempDirectory.getAbsolutePath() + File.separator+name+".pdf"));
	    document.open();
	    PdfPTable table = new PdfPTable(6);

	    table.setWidthPercentage(100);
	    table.setSpacingBefore(0f);
	    table.setSpacingAfter(0f);

	    PdfPCell cell = new PdfPCell(new Phrase("Balance General"));
	    cell.setColspan(10);
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    cell.setPadding(5.0f);
	    cell.setBackgroundColor(new BaseColor(191, 205, 219));
	    table.addCell(cell);

	    table.addCell("Detalle");
	    table.addCell("Nota");
	    table.addCell("Fecha");
	    table.addCell("Ingresos");
	    table.addCell("Egresos");
	    table.addCell("Saldo");
	    
		Double subTotal=0.0;
		Double grandTotal=0.0;

	    for (Contables contable : contables) {
	    	if(contable.getTipo().equals("INGRESO")) {
				subTotal+=contable.getValor();
			}else {
				subTotal-=contable.getValor();
			}
	    	 table.addCell(contable.getDetalle());
	    	 table.addCell(contable.getNota());
	    	 table.addCell(contable.getCreated());
	    	 table.addCell(contable.getTipo().equals("INGRESO")?contable.getValor().toString():"");
	    	 table.addCell(contable.getTipo().equals("EGRESO")?contable.getValor().toString():"");
	    	 table.addCell(subTotal.toString());
	    	 grandTotal=subTotal;
		}
	    //GrandTotal
	    table.addCell("");
	    table.addCell("");
	    table.addCell("");
	    table.addCell("");
	    table.addCell("TOTAL:");
	    table.addCell(grandTotal.toString());
	    document.add(table);
	    document.close();
	}
}
