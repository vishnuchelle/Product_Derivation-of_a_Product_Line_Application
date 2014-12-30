// Generated from XMLParser.g4 by ANTLR 4.3
package home.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XMLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEA_WS=6, EQUALS=14, SPECIAL_CLOSE=11, SLASH=13, TEXT=9, CLOSE=10, COMMENT=1, 
		OPEN=7, Name=16, SLASH_CLOSE=12, S=17, DTD=3, CharRef=5, XMLDeclOpen=8, 
		STRING=15, PI=18, CDATA=2, EntityRef=4;
	public static final String[] tokenNames = {
		"<INVALID>", "COMMENT", "CDATA", "DTD", "EntityRef", "CharRef", "SEA_WS", 
		"'<'", "XMLDeclOpen", "TEXT", "'>'", "SPECIAL_CLOSE", "'/>'", "'/'", "'='", 
		"STRING", "Name", "S", "PI"
	};
	public static final int
		RULE_document = 0, RULE_prolog = 1, RULE_content = 2, RULE_element = 3, 
		RULE_reference = 4, RULE_attribute = 5, RULE_chardata = 6, RULE_misc = 7;
	public static final String[] ruleNames = {
		"document", "prolog", "content", "element", "reference", "attribute", 
		"chardata", "misc"
	};

	@Override
	public String getGrammarFileName() { return "XMLParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XMLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DocumentContext extends ParserRuleContext {
		public MiscContext misc(int i) {
			return getRuleContext(MiscContext.class,i);
		}
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public List<MiscContext> misc() {
			return getRuleContexts(MiscContext.class);
		}
		public PrologContext prolog() {
			return getRuleContext(PrologContext.class,0);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).exitDocument(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_la = _input.LA(1);
			if (_la==XMLDeclOpen) {
				{
				setState(16); prolog();
				}
			}

			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEA_WS || _la==PI) {
				{
				{
				setState(19); misc();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25); element();
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEA_WS || _la==PI) {
				{
				{
				setState(26); misc();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrologContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public TerminalNode SPECIAL_CLOSE() { return getToken(XMLParser.SPECIAL_CLOSE, 0); }
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode XMLDeclOpen() { return getToken(XMLParser.XMLDeclOpen, 0); }
		public PrologContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prolog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).enterProlog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).exitProlog(this);
		}
	}

	public final PrologContext prolog() throws RecognitionException {
		PrologContext _localctx = new PrologContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prolog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); match(XMLDeclOpen);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Name) {
				{
				{
				setState(33); attribute();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39); match(SPECIAL_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContentContext extends ParserRuleContext {
		public TerminalNode CDATA(int i) {
			return getToken(XMLParser.CDATA, i);
		}
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public List<ChardataContext> chardata() {
			return getRuleContexts(ChardataContext.class);
		}
		public List<TerminalNode> PI() { return getTokens(XMLParser.PI); }
		public List<ReferenceContext> reference() {
			return getRuleContexts(ReferenceContext.class);
		}
		public TerminalNode PI(int i) {
			return getToken(XMLParser.PI, i);
		}
		public ChardataContext chardata(int i) {
			return getRuleContext(ChardataContext.class,i);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public ReferenceContext reference(int i) {
			return getRuleContext(ReferenceContext.class,i);
		}
		public List<TerminalNode> CDATA() { return getTokens(XMLParser.CDATA); }
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).exitContent(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_content);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_la = _input.LA(1);
			if (_la==SEA_WS || _la==TEXT) {
				{
				setState(41); chardata();
				}
			}

			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(48);
					switch (_input.LA(1)) {
					case OPEN:
						{
						setState(44); element();
						}
						break;
					case EntityRef:
					case CharRef:
						{
						setState(45); reference();
						}
						break;
					case CDATA:
						{
						setState(46); match(CDATA);
						}
						break;
					case PI:
						{
						setState(47); match(PI);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(51);
					_la = _input.LA(1);
					if (_la==SEA_WS || _la==TEXT) {
						{
						setState(50); chardata();
						}
					}

					}
					} 
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode Name(int i) {
			return getToken(XMLParser.Name, i);
		}
		public List<TerminalNode> Name() { return getTokens(XMLParser.Name); }
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).exitElement(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_element);
		int _la;
		try {
			setState(82);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58); match(OPEN);
				setState(59); match(Name);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Name) {
					{
					{
					setState(60); attribute();
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66); match(CLOSE);
				setState(67); content();
				setState(68); match(OPEN);
				setState(69); match(SLASH);
				setState(70); match(Name);
				setState(71); match(CLOSE);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73); match(OPEN);
				setState(74); match(Name);
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Name) {
					{
					{
					setState(75); attribute();
					}
					}
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(81); match(SLASH_CLOSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceContext extends ParserRuleContext {
		public TerminalNode CharRef() { return getToken(XMLParser.CharRef, 0); }
		public TerminalNode EntityRef() { return getToken(XMLParser.EntityRef, 0); }
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).exitReference(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_reference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_la = _input.LA(1);
			if ( !(_la==EntityRef || _la==CharRef) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(XMLParser.STRING, 0); }
		public TerminalNode Name() { return getToken(XMLParser.Name, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(Name);
			setState(87); match(EQUALS);
			setState(88); match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChardataContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(XMLParser.TEXT, 0); }
		public TerminalNode SEA_WS() { return getToken(XMLParser.SEA_WS, 0); }
		public ChardataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chardata; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).enterChardata(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).exitChardata(this);
		}
	}

	public final ChardataContext chardata() throws RecognitionException {
		ChardataContext _localctx = new ChardataContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_chardata);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_la = _input.LA(1);
			if ( !(_la==SEA_WS || _la==TEXT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MiscContext extends ParserRuleContext {
		public TerminalNode SEA_WS() { return getToken(XMLParser.SEA_WS, 0); }
		public TerminalNode PI() { return getToken(XMLParser.PI, 0); }
		public MiscContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_misc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).enterMisc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).exitMisc(this);
		}
	}

	public final MiscContext misc() throws RecognitionException {
		MiscContext _localctx = new MiscContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_misc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !(_la==SEA_WS || _la==PI) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\24a\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\5\2\24\n\2\3\2"+
		"\7\2\27\n\2\f\2\16\2\32\13\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\3\3\3"+
		"\7\3%\n\3\f\3\16\3(\13\3\3\3\3\3\3\4\5\4-\n\4\3\4\3\4\3\4\3\4\5\4\63\n"+
		"\4\3\4\5\4\66\n\4\7\48\n\4\f\4\16\4;\13\4\3\5\3\5\3\5\7\5@\n\5\f\5\16"+
		"\5C\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5O\n\5\f\5\16\5R\13"+
		"\5\3\5\5\5U\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\2\2\n\2\4"+
		"\6\b\n\f\16\20\2\5\3\2\6\7\4\2\b\b\13\13\4\2\b\b\24\24e\2\23\3\2\2\2\4"+
		"\"\3\2\2\2\6,\3\2\2\2\bT\3\2\2\2\nV\3\2\2\2\fX\3\2\2\2\16\\\3\2\2\2\20"+
		"^\3\2\2\2\22\24\5\4\3\2\23\22\3\2\2\2\23\24\3\2\2\2\24\30\3\2\2\2\25\27"+
		"\5\20\t\2\26\25\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\33"+
		"\3\2\2\2\32\30\3\2\2\2\33\37\5\b\5\2\34\36\5\20\t\2\35\34\3\2\2\2\36!"+
		"\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \3\3\2\2\2!\37\3\2\2\2\"&\7\n\2\2#"+
		"%\5\f\7\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2"+
		"\2)*\7\r\2\2*\5\3\2\2\2+-\5\16\b\2,+\3\2\2\2,-\3\2\2\2-9\3\2\2\2.\63\5"+
		"\b\5\2/\63\5\n\6\2\60\63\7\4\2\2\61\63\7\24\2\2\62.\3\2\2\2\62/\3\2\2"+
		"\2\62\60\3\2\2\2\62\61\3\2\2\2\63\65\3\2\2\2\64\66\5\16\b\2\65\64\3\2"+
		"\2\2\65\66\3\2\2\2\668\3\2\2\2\67\62\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3"+
		"\2\2\2:\7\3\2\2\2;9\3\2\2\2<=\7\t\2\2=A\7\22\2\2>@\5\f\7\2?>\3\2\2\2@"+
		"C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\f\2\2EF\5\6\4\2"+
		"FG\7\t\2\2GH\7\17\2\2HI\7\22\2\2IJ\7\f\2\2JU\3\2\2\2KL\7\t\2\2LP\7\22"+
		"\2\2MO\5\f\7\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2"+
		"\2\2SU\7\16\2\2T<\3\2\2\2TK\3\2\2\2U\t\3\2\2\2VW\t\2\2\2W\13\3\2\2\2X"+
		"Y\7\22\2\2YZ\7\20\2\2Z[\7\21\2\2[\r\3\2\2\2\\]\t\3\2\2]\17\3\2\2\2^_\t"+
		"\4\2\2_\21\3\2\2\2\r\23\30\37&,\62\659APT";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}