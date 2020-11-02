# Getdown Releases

## 1.8.6 - June 4, 2019

* Fixed issues with PAC proxy support: added `myIpAddress()`, fixed `dnsResolve()`, fixed crash
  when detecting PAC proxy.

* Reverted env var support in `appbase` and `latest` properties. It's causing problems that need to
  be investigated.
