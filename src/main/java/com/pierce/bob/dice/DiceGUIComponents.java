package com.pierce.bob.dice;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;


class DiceGUIComponents {
	private Text txtAdjustment;
	private Text outputText;
	private Spinner repeatSpinner;
	private Button repeatCheckbox;
	private Label lblAdjustment;
	
	void addD4Button(Shell shlDiceRoller) {
		Button d4 = new Button(shlDiceRoller, SWT.NONE);
		d4.setBounds(115, 33, 63, 25);
		d4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setRollResult(4,repeatSpinner);
			}
		});
		d4.setText("d4");
	}
	
	void addD6Button(Shell shlDiceRoller) {
		Button d6 = new Button(shlDiceRoller, SWT.NONE);
		d6.setBounds(203, 33, 62, 25);
		d6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setRollResult(6,repeatSpinner);
			}
		});
		d6.setText("d6");
	}
	
	void addD8Button(Shell shlDiceRoller) {
		Button d8 = new Button(shlDiceRoller, SWT.NONE);
		d8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setRollResult(8,repeatSpinner);
			}
		});
		d8.setText("d8");
		d8.setBounds(291, 33, 62, 25);
	}
	
	void addD12Button(Shell shlDiceRoller) {
		Button d12 = new Button(shlDiceRoller, SWT.NONE);
		d12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setRollResult(12,repeatSpinner);
			}
		});
		d12.setText("d12");
		d12.setBounds(379, 33, 62, 25);
	}
	
	void addD20Button(Shell shlDiceRoller) {
		Button d20 = new Button(shlDiceRoller, SWT.NONE);
		d20.setBounds(27, 33, 65, 25);
		d20.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setRollResult(20,repeatSpinner);
			}
		});
		d20.setText("d20");
	}
	
	void addD100Button(Shell shlDiceRoller) {
		Button d100 = new Button(shlDiceRoller, SWT.NONE);
		d100.setBounds(467, 33, 62, 25);
		d100.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setRollResult(100,repeatSpinner);
			}
		});
		d100.setText("d100");
	}
	
	void addRepeatCheckbox(Shell shlDiceRoller) {
		repeatCheckbox = new Button(shlDiceRoller, SWT.CHECK);
		repeatCheckbox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (repeatCheckbox.getSelection()){
					repeatSpinner.setVisible(true);
				}
				else{
					repeatSpinner.setVisible(false);
					repeatSpinner.setSelection(2);
				}
			}
		});
		repeatCheckbox.setBounds(39, 110, 93, 16);
		repeatCheckbox.setText("Repeat");
	}
	
	void addRepeatSpinner(Shell shlDiceRoller) {
		repeatSpinner = new Spinner(shlDiceRoller, SWT.BORDER);
		repeatSpinner.setVisible(false);
		repeatSpinner.setMaximum(20);
		repeatSpinner.setMinimum(2);
		repeatSpinner.setBounds(64, 132, 47, 22);
	}
	
	void addDiceImage(Shell shlDiceRoller) {
		CLabel lblNewLabel = new CLabel(shlDiceRoller, SWT.NONE);
		lblNewLabel.setBounds(633, 0, 171, 106);
		lblNewLabel.setImage(SWTResourceManager.getImage("src\\main\\resources\\dice-100-3px.png"));
		lblNewLabel.setText("");
		
		shlDiceRoller.setImage(SWTResourceManager.getImage("src\\main\\resources\\dice-100-3px.png"));
		shlDiceRoller.setSize(830, 330);
		shlDiceRoller.setText("Dice Roller");
	}
	
	
	void addAdjustmentLabel(Shell shlDiceRoller) {
		lblAdjustment = new Label(shlDiceRoller, SWT.NONE);
		lblAdjustment.setBounds(27, 81, 74, 15);
		lblAdjustment.setText("Adjustment:");
	}

	
	void addOutputTextarea(Shell shlDiceRoller) {
		outputText = new Text(shlDiceRoller, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		outputText.setEditable(false);
		outputText.setBounds(17, 214, 599, 67);
	}
	
	void addTextAdjustment(Shell shlDiceRoller) {
		txtAdjustment = new Text(shlDiceRoller, SWT.BORDER);
		txtAdjustment.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (txtAdjustment.getText().length() >= 2 && Character.isDigit(e.character)){
					e.doit = false;
				}
				if (txtAdjustment.getText().length() == 0 && e.character == '0'){
					e.doit = false;
				}
				if (!Character.isDigit(e.character) && e.character != '-' && !(e.keyCode == SWT.BS) && !(e.keyCode == SWT.ARROW_LEFT) && !(e.keyCode == SWT.DEL) && !(e.keyCode == SWT.LEFT) && !(e.keyCode == SWT.RIGHT) && !(e.keyCode == SWT.ARROW_RIGHT)) {
			        e.doit = false;
			    }
			}
		});
		txtAdjustment.setToolTipText("Optional adjustment");
		txtAdjustment.setBounds(114, 75, 30, 21);
		
	}

	private void setRollResult(int dieSides, Spinner repeatSpinner){
		int diceCount = 1;
		short adjustment = (short)((txtAdjustment.getText().length() > 0) ? Integer.parseInt(txtAdjustment.getText()) : 0); 
		if (repeatSpinner.isVisible()){
			diceCount = repeatSpinner.getSelection();
		}
		if (diceCount>1){
			outputText.append(DiceRoller.roll(dieSides, adjustment, diceCount) + System.lineSeparator());
		}
		else{
			outputText.append(DiceRoller.roll(dieSides, adjustment) + System.lineSeparator());
		}
	}
}
