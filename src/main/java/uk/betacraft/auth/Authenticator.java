package uk.betacraft.auth;

import javax.swing.SwingUtilities;

import com.github.teamproteus.launcher.Lang;
import com.github.teamproteus.launcher.Launcher;
import com.github.teamproteus.launcher.Window;

public abstract class Authenticator {

	//public boolean refreshToken();

	public abstract boolean authenticate();

	public abstract boolean invalidate();

	public abstract Credentials getCredentials();

	public void authSuccess() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Window.nick_input.setText(Launcher.getNickname());
				Window.nick_input.setEnabled(false);
				Window.loginButton.setText(Lang.LOGOUT_BUTTON);
				Window.loginButton.setEnabled(true);
				Window.positionButtons();
			}
		});
	};
}
