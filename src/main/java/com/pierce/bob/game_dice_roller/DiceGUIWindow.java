package com.pierce.bob.game_dice_roller;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class DiceGUIWindow {

	protected Shell shlDiceRoller;

	/**
	 * Launch the Game Dice Roller application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DiceGUIWindow window = new DiceGUIWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the GUI Window.
	 */
	void open() {
		Display display = Display.getDefault();
		createContents();
		shlDiceRoller.open();
		shlDiceRoller.layout();
		while (!shlDiceRoller.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the GUI window.
	 */
	void createContents() {
		shlDiceRoller = new Shell();
		shlDiceRoller.setLayout(null);

		DiceGUIComponents diceGUIComponents = new DiceGUIComponents();
		
		diceGUIComponents.addD20Button(shlDiceRoller);
		diceGUIComponents.addD4Button(shlDiceRoller);
		diceGUIComponents.addD6Button(shlDiceRoller);
		diceGUIComponents.addD8Button(shlDiceRoller);
		diceGUIComponents.addD12Button(shlDiceRoller);
		diceGUIComponents.addD100Button(shlDiceRoller);

		diceGUIComponents.addDiceImage(shlDiceRoller);
		diceGUIComponents.addAdjustmentLabel(shlDiceRoller);
		diceGUIComponents.addTextAdjustment(shlDiceRoller);
		diceGUIComponents.addRepeatCheckbox(shlDiceRoller);
		diceGUIComponents.addRepeatSpinner(shlDiceRoller);
		diceGUIComponents.addOutputTextarea(shlDiceRoller);
	}
}
