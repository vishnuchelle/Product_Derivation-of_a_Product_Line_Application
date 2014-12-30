// Generated from XMLLexer.g4 by ANTLR 4.3
package home.antlr4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XMLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, CDATA=2, DTD=3, EntityRef=4, CharRef=5, SEA_WS=6, OPEN=7, XMLDeclOpen=8, 
		TEXT=9, CLOSE=10, SPECIAL_CLOSE=11, SLASH_CLOSE=12, SLASH=13, EQUALS=14, 
		STRING=15, Name=16, S=17, PI=18;
	public static final int INSIDE = 1;
	public static final int PROC_INSTR = 2;
	public static String[] modeNames = {
		"DEFAULT_MODE", "INSIDE", "PROC_INSTR"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'"
	};
	public static final String[] ruleNames = {
		"COMMENT", "CDATA", "DTD", "EntityRef", "CharRef", "SEA_WS", "OPEN", "XMLDeclOpen", 
		"SPECIAL_OPEN", "TEXT", "CLOSE", "SPECIAL_CLOSE", "SLASH_CLOSE", "SLASH", 
		"EQUALS", "STRING", "Name", "S", "HEXDIGIT", "DIGIT", "NameChar", "NameStartChar", 
		"PI", "IGNORE"
	};


	   public static final int WHITESPACE_CHANNEL   = 1;
	   public static final int COMMENT_CHANNEL      = 2;


	public XMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XMLLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 17: S_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void S_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: _channel = WHITESPACE_CHANNEL; break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: _channel = COMMENT_CHANNEL; break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u00f0\b\1\b\1"+
		"\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4"+
		"\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t"+
		"\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t"+
		"\30\4\31\t\31\3\2\3\2\3\2\3\2\3\2\3\2\7\2<\n\2\f\2\16\2?\13\2\3\2\3\2"+
		"\3\2\3\2\3\2\6\2F\n\2\r\2\16\2G\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\7\3W\n\3\f\3\16\3Z\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\7\4d\n\4\f\4\16\4g\13\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\6\6u\n\6\r\6\16\6v\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6\u0080\n\6\r\6\16"+
		"\6\u0081\3\6\3\6\5\6\u0086\n\6\3\7\3\7\5\7\u008a\n\7\3\7\6\7\u008d\n\7"+
		"\r\7\16\7\u008e\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\6\13\u00a8\n\13\r\13\16\13\u00a9"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\7\21\u00c0\n\21\f\21\16\21\u00c3\13\21\3\21\3\21"+
		"\3\21\7\21\u00c8\n\21\f\21\16\21\u00cb\13\21\3\21\5\21\u00ce\n\21\3\22"+
		"\3\22\7\22\u00d2\n\22\f\22\16\22\u00d5\13\22\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u00e3\n\26\3\27\5\27\u00e6\n"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\5=Xe\2\32\5\3\7\4\t\5"+
		"\13\6\r\7\17\b\21\t\23\n\25\2\27\13\31\f\33\r\35\16\37\17!\20#\21%\22"+
		"\'\23)\2+\2-\2/\2\61\24\63\2\5\2\3\4\f\4\2\13\13\"\"\4\2((>>\4\2$$>>\4"+
		"\2))>>\5\2\13\f\17\17\"\"\5\2\62;CHch\3\2\62;\4\2/\60aa\5\2\u00b9\u00b9"+
		"\u0302\u0371\u2041\u2042\n\2<<C\\c|\u2072\u2191\u2c02\u2ff1\u3003\ud801"+
		"\uf902\ufdd1\ufdf2\uffff\u00fb\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\3\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2\2\2\3\37\3\2\2\2\3"+
		"!\3\2\2\2\3#\3\2\2\2\3%\3\2\2\2\3\'\3\2\2\2\4\61\3\2\2\2\4\63\3\2\2\2"+
		"\5\65\3\2\2\2\7K\3\2\2\2\t_\3\2\2\2\13l\3\2\2\2\r\u0085\3\2\2\2\17\u008c"+
		"\3\2\2\2\21\u0090\3\2\2\2\23\u0094\3\2\2\2\25\u009e\3\2\2\2\27\u00a7\3"+
		"\2\2\2\31\u00ab\3\2\2\2\33\u00af\3\2\2\2\35\u00b4\3\2\2\2\37\u00b9\3\2"+
		"\2\2!\u00bb\3\2\2\2#\u00cd\3\2\2\2%\u00cf\3\2\2\2\'\u00d6\3\2\2\2)\u00da"+
		"\3\2\2\2+\u00dc\3\2\2\2-\u00e2\3\2\2\2/\u00e5\3\2\2\2\61\u00e7\3\2\2\2"+
		"\63\u00ec\3\2\2\2\65\66\7>\2\2\66\67\7#\2\2\678\7/\2\289\7/\2\29=\3\2"+
		"\2\2:<\13\2\2\2;:\3\2\2\2<?\3\2\2\2=>\3\2\2\2=;\3\2\2\2>@\3\2\2\2?=\3"+
		"\2\2\2@A\7/\2\2AB\7/\2\2BC\7@\2\2CE\3\2\2\2DF\5\'\23\2ED\3\2\2\2FG\3\2"+
		"\2\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\b\2\2\2J\6\3\2\2\2KL\7>\2\2LM\7#"+
		"\2\2MN\7]\2\2NO\7E\2\2OP\7F\2\2PQ\7C\2\2QR\7V\2\2RS\7C\2\2ST\7]\2\2TX"+
		"\3\2\2\2UW\13\2\2\2VU\3\2\2\2WZ\3\2\2\2XY\3\2\2\2XV\3\2\2\2Y[\3\2\2\2"+
		"ZX\3\2\2\2[\\\7_\2\2\\]\7_\2\2]^\7@\2\2^\b\3\2\2\2_`\7>\2\2`a\7#\2\2a"+
		"e\3\2\2\2bd\13\2\2\2cb\3\2\2\2dg\3\2\2\2ef\3\2\2\2ec\3\2\2\2fh\3\2\2\2"+
		"ge\3\2\2\2hi\7@\2\2ij\3\2\2\2jk\b\4\3\2k\n\3\2\2\2lm\7(\2\2mn\5%\22\2"+
		"no\7=\2\2o\f\3\2\2\2pq\7(\2\2qr\7%\2\2rt\3\2\2\2su\5+\25\2ts\3\2\2\2u"+
		"v\3\2\2\2vt\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7=\2\2y\u0086\3\2\2\2z{\7(\2"+
		"\2{|\7%\2\2|}\7z\2\2}\177\3\2\2\2~\u0080\5)\24\2\177~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0084\7=\2\2\u0084\u0086\3\2\2\2\u0085p\3\2\2\2\u0085z\3\2\2\2\u0086"+
		"\16\3\2\2\2\u0087\u008d\t\2\2\2\u0088\u008a\7\17\2\2\u0089\u0088\3\2\2"+
		"\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\7\f\2\2\u008c\u0087"+
		"\3\2\2\2\u008c\u0089\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\20\3\2\2\2\u0090\u0091\7>\2\2\u0091\u0092\3\2\2\2"+
		"\u0092\u0093\b\b\4\2\u0093\22\3\2\2\2\u0094\u0095\7>\2\2\u0095\u0096\7"+
		"A\2\2\u0096\u0097\7z\2\2\u0097\u0098\7o\2\2\u0098\u0099\7n\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\u009b\5\'\23\2\u009b\u009c\3\2\2\2\u009c\u009d\b\t\4\2"+
		"\u009d\24\3\2\2\2\u009e\u009f\7>\2\2\u009f\u00a0\7A\2\2\u00a0\u00a1\3"+
		"\2\2\2\u00a1\u00a2\5%\22\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\b\n\5\2\u00a4"+
		"\u00a5\b\n\6\2\u00a5\26\3\2\2\2\u00a6\u00a8\n\3\2\2\u00a7\u00a6\3\2\2"+
		"\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\30"+
		"\3\2\2\2\u00ab\u00ac\7@\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\b\f\7\2\u00ae"+
		"\32\3\2\2\2\u00af\u00b0\7A\2\2\u00b0\u00b1\7@\2\2\u00b1\u00b2\3\2\2\2"+
		"\u00b2\u00b3\b\r\7\2\u00b3\34\3\2\2\2\u00b4\u00b5\7\61\2\2\u00b5\u00b6"+
		"\7@\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\b\16\7\2\u00b8\36\3\2\2\2\u00b9"+
		"\u00ba\7\61\2\2\u00ba \3\2\2\2\u00bb\u00bc\7?\2\2\u00bc\"\3\2\2\2\u00bd"+
		"\u00c1\7$\2\2\u00be\u00c0\n\4\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2"+
		"\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c4\u00ce\7$\2\2\u00c5\u00c9\7)\2\2\u00c6\u00c8\n\5\2"+
		"\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00ce\7)\2\2\u00cd"+
		"\u00bd\3\2\2\2\u00cd\u00c5\3\2\2\2\u00ce$\3\2\2\2\u00cf\u00d3\5/\27\2"+
		"\u00d0\u00d2\5-\26\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4&\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6"+
		"\u00d7\t\6\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\b\23\b\2\u00d9(\3\2\2\2"+
		"\u00da\u00db\t\7\2\2\u00db*\3\2\2\2\u00dc\u00dd\t\b\2\2\u00dd,\3\2\2\2"+
		"\u00de\u00e3\5/\27\2\u00df\u00e3\t\t\2\2\u00e0\u00e3\5+\25\2\u00e1\u00e3"+
		"\t\n\2\2\u00e2\u00de\3\2\2\2\u00e2\u00df\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2"+
		"\u00e1\3\2\2\2\u00e3.\3\2\2\2\u00e4\u00e6\t\13\2\2\u00e5\u00e4\3\2\2\2"+
		"\u00e6\60\3\2\2\2\u00e7\u00e8\7A\2\2\u00e8\u00e9\7@\2\2\u00e9\u00ea\3"+
		"\2\2\2\u00ea\u00eb\b\30\7\2\u00eb\62\3\2\2\2\u00ec\u00ed\13\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00ef\b\31\5\2\u00ef\64\3\2\2\2\26\2\3\4=GXev\u0081"+
		"\u0085\u0089\u008c\u008e\u00a9\u00c1\u00c9\u00cd\u00d3\u00e2\u00e5\t\3"+
		"\2\2\b\2\2\7\3\2\5\2\2\7\4\2\6\2\2\3\23\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}