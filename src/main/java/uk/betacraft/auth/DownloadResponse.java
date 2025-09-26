package uk.betacraft.auth;

import com.github.teamproteus.launcher.DownloadResult;

public class DownloadResponse extends Response {

	public DownloadResult result;
	public String err_response;

	public DownloadResponse(DownloadResult result, String res) {
		this.result = result;
		this.err_response = res;
	}
}
